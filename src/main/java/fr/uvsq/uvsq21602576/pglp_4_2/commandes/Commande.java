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
     * @return 
     * @throws CommandeImpossibleException 
     * @throws UndoImpossibleException
     */
    boolean execute() throws CommandeImpossibleException, UndoImpossibleException;
}
