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

/**
 * Test pour Interpreteur.
 * @author Flora
 *
 */
public class InterpreteurTest {

    /**
     * Teste la construction.
     */
    @Test
    public void constructeurTest() {
        Interpreteur i = new Interpreteur(null);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("exit");
        expected.add("help");
        expected.add("undo");
        assertEquals(expected, i.keySet());
    }
    
    /**
     * Teste l'enregistrement de commande.
     */
    @Test
    public void enregistreTest() {
        Interpreteur i = new Interpreteur(null);
        i.enregistre("test", new Commande() {
            public void execute() {
            }
        });
        assertTrue(i.keySet().contains("test"));
    }
    
    /**
     * Teste l'execution de commande.
     * Dans le cas où tout marche bien,
     * avec une commande non annulable.
     * @throws NoCommandException   Si la commande n'existe pas.
     * @throws CommandeImpossibleException  Si la commande est impossible.
     * @throws UndoImpossibleException  Si la commande undo echoue.
     */
    @Test
    public void executeTest() throws NoCommandException, CommandeImpossibleException, UndoImpossibleException {
        Interpreteur i = new Interpreteur(null);
        i.enregistre("test", new Commande() {
            public void execute() {
            }
        });
        i.execute("test");
    }
    
    /**
     * Teste l'execution de commande.
     * Dans le cas où tout marche bien,
     * avec une commande annulable.
     * @throws NoCommandException   Si la commande n'existe pas.
     * @throws CommandeImpossibleException  Si la commande est impossible.
     * @throws UndoImpossibleException  Si la commande undo echoue.
     */
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
    
    /**
     * Teste l'execution de commande.
     * En cas de commande non existante.
     * @throws NoCommandException   Si la commande n'existe pas.
     * @throws CommandeImpossibleException  Si la commande est impossible.
     * @throws UndoImpossibleException  Si la commande undo echoue.
     */
    @Test(expected=NoCommandException.class)
    public void executeExceptionInconnuTest() throws NoCommandException, CommandeImpossibleException, UndoImpossibleException {
        Interpreteur i = new Interpreteur(null);
        i.execute("test");
    }
    
    /**
     * Teste l'execution de commande.
     * En cas de commande impossible.
     * @throws NoCommandException   Si la commande n'existe pas.
     * @throws CommandeImpossibleException  Si la commande est impossible.
     * @throws UndoImpossibleException  Si la commande undo echoue.
     */
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

    /**
     * Teste l'affichage des commandes.
     */
    @Test
    public void afficheCommandeTest() {
        Interpreteur i = new Interpreteur(null);
        String expected = "[exit, help, undo]";
        assertEquals(expected, i.afficheCommandes());
    }
}
