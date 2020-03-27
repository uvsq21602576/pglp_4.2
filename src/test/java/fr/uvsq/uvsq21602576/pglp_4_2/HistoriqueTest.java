package fr.uvsq.uvsq21602576.pglp_4_2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import fr.uvsq.uvsq21602576.pglp_4_2.commandes.CommandeUndoable;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.CommandeImpossibleException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.UndoImpossibleException;

public class HistoriqueTest {

    @Test
    public void addTest() {
        Historique h = new Historique();
        CommandeUndoable c = new CommandeUndoable() {
            @Override
            public void execute() throws CommandeImpossibleException, UndoImpossibleException { }

            @Override
            public void undo() throws UndoImpossibleException { }
        };
        h.ajoute(c);
        ArrayList<CommandeUndoable> expected = new ArrayList<>();
        expected.add(c);
        assertEquals(expected, h.getHistorique());
    }

    @Test
    public void retourArriereTest() throws UndoImpossibleException {
        Historique h = new Historique();
        CommandeUndoable c = new CommandeUndoable() {
            @Override
            public void execute() throws CommandeImpossibleException, UndoImpossibleException {
            }

            @Override
            public void undo() throws UndoImpossibleException {
            }
        };
        h.ajoute(c);
        h.retourArriere();
        assertTrue(h.getHistorique().isEmpty());
    }

    @Test(expected=UndoImpossibleException.class)
    public void retourArriereExceptionVideTest() throws UndoImpossibleException {
        Historique h = new Historique();
        h.retourArriere();
    }

    @Test
    public void retourArriereExceptionImpossibleTest() {
        Historique h = new Historique();
        CommandeUndoable c = new CommandeUndoable() {
            @Override
            public void execute() throws CommandeImpossibleException, UndoImpossibleException {
            }

            @Override
            public void undo() throws UndoImpossibleException {
                throw new UndoImpossibleException("test");
            }
        };
        h.ajoute(c);

        try {
            h.retourArriere();
            fail("Expected UndoImpossibleException to be thrown");
        } catch (UndoImpossibleException e) {
            ArrayList<CommandeUndoable> expected = new ArrayList<>();
            expected.add(c);
            assertEquals(expected, h.getHistorique());
        }
    }
}
