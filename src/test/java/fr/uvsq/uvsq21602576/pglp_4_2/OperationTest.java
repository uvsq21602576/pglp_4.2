package fr.uvsq.uvsq21602576.pglp_4_2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.DivisionParZeroException;

/**
 * Teste Operation.
 * @author Flora
 */
public class OperationTest {

    /**
     * Teste l'évaluation.
     * Cas de l'addition.
     * @throws DivisionParZeroException En cas de divions par zéro.
     */
    @Test
    public void evalPlusTest() throws DivisionParZeroException {
        assertEquals(1.2 + 2.1, Operation.PLUS.eval(1.2, 2.1), 0);
    }

    /**
     * Teste l'évaluation.
     * Cas de la soustraction.
     * @throws DivisionParZeroException En cas de divions par zéro.
     */
    @Test
    public void evalMoinsTest() throws DivisionParZeroException {
        assertEquals(1.2 - 2.1, Operation.MOINS.eval(1.2, 2.1), 0);
    }

    /**
     * Teste l'évaluation.
     * Cas de la multiplication.
     * @throws DivisionParZeroException En cas de divions par zéro.
     */
    @Test
    public void evalMutliplicationTest() throws DivisionParZeroException {
        assertEquals(1.2 * 2.1, Operation.MULT.eval(1.2, 2.1), 0);
    }

    /**
     * Teste l'évaluation.
     * Cas de la division.
     * @throws DivisionParZeroException En cas de divions par zéro.
     */
    @Test
    public void evalDivisionTest() throws DivisionParZeroException {
        assertEquals(1.2 / 2.1, Operation.DIV.eval(1.2, 2.1), 0);
    }

    /**
     * Teste l'évaluation.
     * Cas de la division par zéro.
     * @throws DivisionParZeroException En cas de divions par zéro.
     */
    @Test(expected = DivisionParZeroException.class)
    public void evalExceptionDivParZeroTest() throws DivisionParZeroException {
        Operation.DIV.eval(10, 0);
    }

    /**
     * Teste la récupération de l'opération.
     * Cas de l'addition.
     */
    @Test
    public void getOperationPlusTest() {
        assertEquals(Operation.PLUS, Operation.getOperation('+'));
    }
    /**
     * Teste la récupération de l'opération.
     * Cas de la soustraction.
     */
    @Test
    public void getOperationMoinsTest() {
        assertEquals(Operation.MOINS, Operation.getOperation('-'));
    }
    /**
     * Teste la récupération de l'opération.
     * Cas de la multiplication.
     */
    @Test
    public void getOperationMultTest() {
        assertEquals(Operation.MULT, Operation.getOperation('*'));
    }
    /**
     * Teste la récupération de l'opération.
     * Cas de la division.
     */
    @Test
    public void getOperationDivTest() {
        assertEquals(Operation.DIV, Operation.getOperation('/'));
    }

    /**
     * Teste isOperateur
     * Cas opération existante.
     */
    @Test
    public void isOperateurTrueTest() {
        assertTrue(Operation.isOperateur("+"));
    }
    /**
     * Teste isOperateur
     * Cas opération non existante.
     */
    @Test
    public void isOperateurFalseTest() {
        assertFalse(Operation.isOperateur("$"));
    }

}
