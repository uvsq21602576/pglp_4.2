package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import fr.uvsq.uvsq21602576.pglp_4_2.MoteurRPN;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.OperandeAbsenteException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.UndoImpossibleException;

public class CommandeAjoutOperande implements CommandeUndoable {
    private MoteurRPN moteur;
    private double operande;
    
    public CommandeAjoutOperande(MoteurRPN m, double ope) {
        this.moteur = m;
        this.operande = ope;
    }
    
    public void execute() {
        moteur.enregistreOperande(operande);
    }

    public void undo() throws UndoImpossibleException {
        double ope = 0;
        try {
            ope = moteur.retireOperande();
        } catch (OperandeAbsenteException e) {
            throw new UndoImpossibleException(e.getMessage());
        }
        if(ope != operande) {
            moteur.enregistreOperande(ope);
            throw new UndoImpossibleException("Mauvaise opérande.");
        }
    }
}
