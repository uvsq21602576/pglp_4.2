package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import fr.uvsq.uvsq21602576.pglp_4_2.Historique;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.UndoImpossibleException;

/**
 * Commande pour annuler la dernière commande faite.
 * @author Flora
 */
public class CommandeUndo implements Commande {
    /**
     * Historique de commande.
     */
    private Historique historique;

    /**
     * Constrcuteur.
     * Crée la commande à partir de l'historique.
     * @param h Historique.
     */
    public CommandeUndo(final Historique h) {
        this.historique = h;
    }

    /**
     * Execution.
     * Annule la dernieère commande de l'historique.
     * @throws UndoImpossibleException  En cas d'echec de l'annulation.
     */
    public void execute() throws UndoImpossibleException {
        historique.retourArriere();
        System.out.println("undo effectué");
    }

}
