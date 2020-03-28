package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.CommandeImpossibleException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.UndoImpossibleException;

/**
 * Interface commande.
 * @author Flora
 */
public interface Commande {

    /**
     * Code à lancer à l'éxecution de cette commande.
     * @throws CommandeImpossibleException  Si la commande
     *      se relève impossible à effectuer.
     * @throws UndoImpossibleException  Si la commande undo échoue.
     */
    void execute() throws CommandeImpossibleException, UndoImpossibleException;
}
