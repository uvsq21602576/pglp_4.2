package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.CommandeImpossibleException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.UndoImpossibleException;

/**
 * Interface commande.
 * Peut être annulée.
 * @author Flora
 */
public interface CommandeUndoable extends Commande {

    /**
     * Code à lancer à l'annulation de cette commande.
     * @throws UndoImpossibleException  EN cas d'echec.
     */
    void undo() throws UndoImpossibleException;
}
