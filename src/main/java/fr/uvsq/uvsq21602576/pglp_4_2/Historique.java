package fr.uvsq.uvsq21602576.pglp_4_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.uvsq.uvsq21602576.pglp_4_2.commandes.CommandeUndoable;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.UndoImpossibleException;

public class Historique {
    private ArrayList<CommandeUndoable> historique;

    public Historique() {
        historique =  new ArrayList<CommandeUndoable>();
    }
    
    public void ajoute(CommandeUndoable c) {
        historique.add(c);
    }
    
    public void retourArriere() throws UndoImpossibleException {
        if(historique.isEmpty()) {
            throw new UndoImpossibleException("L'historique est vide.");
        }
        CommandeUndoable c = historique.remove(historique.size() - 1);
        try {
            c.undo();
        } catch (UndoImpossibleException e) {
            historique.add(c);
            throw e;
        }
    }
    
    public List<CommandeUndoable> getHistorique() {
        return Collections.unmodifiableList(historique);
    }

}
