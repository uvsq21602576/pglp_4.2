package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import fr.uvsq.uvsq21602576.pglp_4_2.MoteurRPN;
import fr.uvsq.uvsq21602576.pglp_4_2.Operation;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.CommandeImpossibleException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.UndoImpossibleException;

/**
 * Teste la commande Operation.
 * @author Flora
 */
public class CommandeOperationTest {

    /**
     * Teste son execution.
     * Quand tout marche bien.
     * @throws CommandeImpossibleException  En cas d'echec de la commande.
     */
    @Test
    public void executeTest() throws CommandeImpossibleException {
        MoteurRPN m = new MoteurRPN(null);
        m.enregistreOperande(3.);
        m.enregistreOperande(5.);
        CommandeOperation c = new CommandeOperation(m, Operation.PLUS);
        c.execute();

        ArrayList<Double> expected = new ArrayList<>();
        expected.add(3. + 5);
        assertEquals(expected, m.getOperandes());
    }

    /**
     * Teste son execution.
     * En cas de division par zero.
     */
    @Test
    public void executeExceptionDivZeroTest() {
        MoteurRPN m = new MoteurRPN(null);
        m.enregistreOperande(3.);
        m.enregistreOperande(0);
        CommandeOperation c = new CommandeOperation(m, Operation.DIV);
        try {
            c.execute();
            fail("Expected CommandeImpossibleException to be thrown");
        } catch (CommandeImpossibleException e) {
            ArrayList<Double> expected = new ArrayList<>();
            expected.add(3.);
            expected.add(0.);
            assertEquals(expected, m.getOperandes());
        }
    }

    /**
     * Teste son execution.
     * En cas de moteur vide.
     * @throws CommandeImpossibleException  En cas d'echec de la commande.
     */
    @Test(expected = CommandeImpossibleException.class)
    public void executeExceptionVideTest() throws CommandeImpossibleException {
        MoteurRPN m = new MoteurRPN(null);
        CommandeOperation c = new CommandeOperation(m, Operation.DIV);
        c.execute();
    }

    /**
     * Teste son execution.
     * En cas de moteur à une seule opérande.
     */
    @Test
    public void executeExceptionPasAssezTest() {
        MoteurRPN m = new MoteurRPN(null);
        m.enregistreOperande(3.);
        CommandeOperation c = new CommandeOperation(m, Operation.DIV);
        try {
            c.execute();
            fail("Expected CommandeImpossibleException to be thrown");
        } catch (CommandeImpossibleException e) {
            ArrayList<Double> expected = new ArrayList<>();
            expected.add(3.);
            assertEquals(expected, m.getOperandes());
        }
    }

    /**
     * Teste l'annulation.
     * Quand tout marche bien.
     * @throws UndoImpossibleException  En cas d'echec de l'undo.
     * @throws CommandeImpossibleException En cas d'echec de la commande.
     */
    @Test
    public void undoTest() throws UndoImpossibleException,
    CommandeImpossibleException {
        MoteurRPN m = new MoteurRPN(null);
        m.enregistreOperande(3.);
        m.enregistreOperande(5.);
        CommandeOperation c = new CommandeOperation(m, Operation.PLUS);
        c.execute();
        c.undo();

        ArrayList<Double> expected = new ArrayList<>();
        expected.add(3.);
        expected.add(5.);
        assertEquals(expected, m.getOperandes());
    }

    /**
     * Teste l'annulation.
     * Quand l'etat du moteur ne correspondant pas avec la commande à annuler.
     * @throws CommandeImpossibleException En cas d'echec de la commande.
     */
    @Test
    public void undoExceptionMauvaiseTest() throws CommandeImpossibleException {
        MoteurRPN m = new MoteurRPN(null);
        m.enregistreOperande(3.);
        m.enregistreOperande(5.);
        CommandeOperation c = new CommandeOperation(m, Operation.PLUS);
        CommandeOperation c2 = new CommandeOperation(m, Operation.DIV);
        c.execute();
        try {
            c2.undo();
            fail("Expected UndoImpossibleExpection to be thrown");
        } catch (UndoImpossibleException e) {
            ArrayList<Double> expected = new ArrayList<>();
            expected.add(8.);
            assertEquals(expected, m.getOperandes());
            assertEquals("Undo impossible à exécuter : Mauvaise opération.",
                    e.getMessage());
        }
    }

    /**
     * Teste l'annulation.
     * Quand le moteur est vide.
     * @throws CommandeImpossibleException En cas d'echec de la commande.
     */
    @Test
    public void undoExceptionVideTest() throws CommandeImpossibleException {
        MoteurRPN m = new MoteurRPN(null);
        CommandeOperation c = new CommandeOperation(m, Operation.PLUS);
        try {
            c.undo();
            fail("Expected UndoImpossibleExpection to be thrown");
        } catch (UndoImpossibleException e) {
            assertEquals("Undo impossible à exécuter : "
                    + "Aucune opérande présente comme résultat précédent.",
                    e.getMessage());
        }
    }
}
