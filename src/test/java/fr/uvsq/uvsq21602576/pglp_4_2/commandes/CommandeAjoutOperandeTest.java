package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import fr.uvsq.uvsq21602576.pglp_4_2.MoteurRPN;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.UndoImpossibleException;

public class CommandeAjoutOperandeTest {

    @Test
    public void executeTest() {
        MoteurRPN m = new MoteurRPN(null);
        CommandeAjoutOperande c = new CommandeAjoutOperande(m, 3);
        c.execute();
        ArrayList<Double> expected = new ArrayList<>();
        expected.add(3.);
        assertEquals(expected, m.getOperandes());
    }
    
    @Test
    public void undoTest() throws UndoImpossibleException {
        MoteurRPN m = new MoteurRPN(null);
        CommandeAjoutOperande c = new CommandeAjoutOperande(m, 3);
        c.execute();
        c.undo();
        assertTrue(m.getOperandes().isEmpty());
    }
    
    @Test(expected=UndoImpossibleException.class)
    public void undoExceptionVideTest() throws UndoImpossibleException {
        MoteurRPN m = new MoteurRPN(null);
        CommandeAjoutOperande c = new CommandeAjoutOperande(m, 3);
        c.undo();
    }
    
    @Test
    public void undoExceptionMauvaiseTest() {
        MoteurRPN m = new MoteurRPN(null);
        CommandeAjoutOperande c = new CommandeAjoutOperande(m, 3);
        CommandeAjoutOperande c2 = new CommandeAjoutOperande(m, 6);
        c2.execute();
        try {
            c.undo();
            fail("Expected UndoImpossibleException to be thrown");
        } catch (UndoImpossibleException e) {
            ArrayList<Double> expected = new ArrayList<>();
            expected.add(6.);
            assertEquals(expected, m.getOperandes());
        }
    }
}
