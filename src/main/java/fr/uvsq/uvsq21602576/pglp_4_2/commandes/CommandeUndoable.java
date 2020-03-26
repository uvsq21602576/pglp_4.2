package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.UndoImpossibleException;

public interface CommandeUndoable extends Commande {
    
    void undo() throws UndoImpossibleException;
}
