package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import fr.uvsq.uvsq21602576.pglp_4_2.MoteurRPN;
import fr.uvsq.uvsq21602576.pglp_4_2.Operation;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.CommandeImpossibleException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.DivisionParZeroException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.OperandeAbsenteException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.UndoImpossibleException;

public class CommandeOperation implements CommandeUndoable {
    private MoteurRPN moteur;
    private Operation operation;
    private Double a = null;
    private Double b = null;
    
    public CommandeOperation(MoteurRPN m, Operation ope) {
        this.moteur = m;
        this.operation = ope;
    }

    public void execute() throws CommandeImpossibleException {
        try {
            b = this.moteur.retireOperande();
        } catch (OperandeAbsenteException e1) {
            throw new CommandeImpossibleException(e1.getMessage());
        }
        try {
            a = this.moteur.retireOperande();
        } catch (OperandeAbsenteException e1) {
            this.moteur.enregistreOperande(b);
            throw new CommandeImpossibleException(e1.getMessage());
        }
        try {
            this.moteur.enregistreOperande(
                    operation.eval(a, b));
        } catch (DivisionParZeroException e) {
            this.moteur.enregistreOperande(a);
            this.moteur.enregistreOperande(b);
            throw new CommandeImpossibleException(e.getMessage());
        }
    }

    public void undo() throws UndoImpossibleException {
        Double result;
        try {
            result = this.moteur.retireOperande();
        } catch (OperandeAbsenteException e1) {
            throw new UndoImpossibleException("Aucune opérande présente comme résultat précédent.");
        }
        try {
            if(a==null || b==null || this.operation.eval(a,b) != result) {
                this.moteur.enregistreOperande(result);
                throw new UndoImpossibleException("Mauvaise opération.");
            }
        } catch (DivisionParZeroException e) {
            this.moteur.enregistreOperande(result);
            e.printStackTrace();
            throw new UndoImpossibleException("Mauvaise opération.");
        }
        this.moteur.enregistreOperande(a);
        this.moteur.enregistreOperande(b);
    }

}
