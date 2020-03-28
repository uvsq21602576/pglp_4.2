package fr.uvsq.uvsq21602576.pglp_4_2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;

import fr.uvsq.uvsq21602576.pglp_4_2.commandes.Commande;
import fr.uvsq.uvsq21602576.pglp_4_2.commandes.CommandeUndoable;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.CommandeImpossibleException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.NoCommandException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.UndoImpossibleException;

public class InterpreteurTest {

    @Test
    public void constructeurTest() {
        Interpreteur i = new Interpreteur(null);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("exit");
        expected.add("help");
        expected.add("undo");
        assertEquals(expected, i.keySet());
    }
    
    @Test
    public void enregistreTest() {
        Interpreteur i = new Interpreteur(null);
        i.enregistre("test", new Commande() {
            public void execute() {
            }
        });
        assertTrue(i.keySet().contains("test"));
    }
    
    @Test
    public void executeTest() throws NoCommandException, CommandeImpossibleException, UndoImpossibleException {
        Interpreteur i = new Interpreteur(null);
        i.enregistre("test", new Commande() {
            public void execute() {
            }
        });
        i.execute("test");
    }
    
    @Test
    public void executeHistoriqueTest() throws NoCommandException, CommandeImpossibleException, UndoImpossibleException {
        Interpreteur i = new Interpreteur(null);
        CommandeUndoable c = new CommandeUndoable() {
            public void execute() {
            }

            @Override
            public void undo() throws UndoImpossibleException {
            }
        };
        i.enregistre("test", c);
        i.execute("test");
        ArrayList<CommandeUndoable> expected = new ArrayList<>();
        expected.add(c);
        assertEquals(expected,i.getHistorique());
    }
    
    @Test(expected=NoCommandException.class)
    public void executeExceptionTest() throws NoCommandException, CommandeImpossibleException, UndoImpossibleException {
        Interpreteur i = new Interpreteur(null);
        i.execute("test");
    }
    
    @Test(expected=CommandeImpossibleException.class)
    public void executeExceptionCommandeTest() throws NoCommandException, CommandeImpossibleException, UndoImpossibleException {
        Interpreteur i = new Interpreteur(null);
        i.enregistre("test", new Commande() {
            public void execute() throws CommandeImpossibleException {
                throw new CommandeImpossibleException("test");
            }
        });
        i.execute("test");
    }

    @Test
    public void afficheCommandeTest() {
        Interpreteur i = new Interpreteur(null);
        String expected = "[exit, help, undo]";
        assertEquals(expected, i.afficheCommandes());
    }
}
