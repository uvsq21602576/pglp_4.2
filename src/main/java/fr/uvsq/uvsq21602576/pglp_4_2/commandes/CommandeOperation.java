package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import fr.uvsq.uvsq21602576.pglp_4_2.MoteurRPN;
import fr.uvsq.uvsq21602576.pglp_4_2.Operation;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.CommandeImpossibleException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.DivisionParZeroException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.OperandeAbsenteException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.UndoImpossibleException;

/**
 * Comme pour effectuer une opération.
 * @author Flora
 */
public class CommandeOperation implements CommandeUndoable {
    /**
     * Moteru dans lequelle elle est appelée.
     */
    private MoteurRPN moteur;
    /**
     * Operation a effectuer.
     */
    private Operation operation;
    /**
     * Opérande sur lequel effectuer l'opération.
     */
    private Double a = null;
    /**
     * Opérande sur lequel effectuer l'opération.
     */
    private Double b = null;

    /**
     * Constructeur.
     * Crée la commande à partir du moteur dans lequel
     * elle est appelée et l'opération à effectuée.
     * @param m Moteur
     * @param ope   Operation à effectuer
     */
    public CommandeOperation(MoteurRPN m, Operation ope) {
        this.moteur = m;
        this.operation = ope;
    }

    /**
     * Execution.
     * Effectue l'opération avec les deux premières opérandes
     * du moteur, retirée de la pile, et ajoute le resulat dans la pile.
     * @throws CommandeImpossibleException 
     *      Si il manque des opérandes ou que l'opération est impossbile.
     */
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

    /**
     * Annulation.
     * Retire le resulat de l'opération et
     * remets les opérandes dans le moteur.
     * @throws UndoImpossibleException Si aucun résulat n'est présent,
     *      ou si l'opération effectué ne correspond pas au résultat dans le moteur.
     */
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
