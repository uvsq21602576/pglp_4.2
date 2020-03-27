package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import fr.uvsq.uvsq21602576.pglp_4_2.Historique;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.UndoImpossibleException;

/**
 * Commande pour annuler la dernière commande faite.
 * @author Flora
 */
public class CommandeUndo implements Commande {
    private Historique historique;

    public CommandeUndo(Historique h) {
        this.historique = h;
    }

    public void execute() throws UndoImpossibleException {
        historique.retourArriere();
        System.out.println("undo effectué");
    }

}
