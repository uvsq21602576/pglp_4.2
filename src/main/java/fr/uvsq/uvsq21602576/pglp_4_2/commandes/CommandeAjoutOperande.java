package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import fr.uvsq.uvsq21602576.pglp_4_2.MoteurRPN;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.OperandeAbsenteException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.UndoImpossibleException;

/**
 * Commande pour ajouter une opérande au moteur.
 * @author Flora
 */
public class CommandeAjoutOperande implements CommandeUndoable {
    /**
     * Moteur où elle est appelée.
     */
    private MoteurRPN moteur;
    /**
     * Opérande ajoutée.
     */
    private double operande;

    /**
     * Constrcuteur.
     * Crée la commande avec le moteur dans lequel elle est appelée.
     * Et l'opérande à ajouter.
     * @param m Moteur
     * @param ope   Opérande à ajouter.
     */
    public CommandeAjoutOperande(final MoteurRPN m, final double ope) {
        this.moteur = m;
        this.operande = ope;
    }

    /**
     * Execution.
     * Ajoute l'operande au moteur.
     */
    public void execute() {
        moteur.enregistreOperande(operande);
    }

    /**
     * Annulation.
     * Retire l'opérande ajouté du moteur.
     * @throws UndoImpossibleException Si le moteur est vide,
     *      ou ne contient pas la même opérande qui a été ajoutée.
     */
    public void undo() throws UndoImpossibleException {
        double ope = 0;
        try {
            ope = moteur.retireOperande();
        } catch (OperandeAbsenteException e) {
            throw new UndoImpossibleException(e.getMessage());
        }
        if (ope != operande) {
            moteur.enregistreOperande(ope);
            throw new UndoImpossibleException("Mauvaise opérande.");
        }
    }
}
