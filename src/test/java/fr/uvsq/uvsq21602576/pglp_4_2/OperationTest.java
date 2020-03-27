package fr.uvsq.uvsq21602576.pglp_4_2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.DivisionParZeroException;

public class OperationTest {
	
	@Test
	public void evalPlusTest() throws DivisionParZeroException {
		assert(Operation.PLUS.eval(1.2,2.1)==1.2+2.1);
	}
	
	@Test
	public void evalMoinsTest() throws DivisionParZeroException {
		assert(Operation.MOINS.eval(1.2,2.1)==1.2-2.1);
	}
	
	@Test
	public void evalMutliplicationTest() throws DivisionParZeroException {
		assert(Operation.MULT.eval(1.2,2.1)==1.2*2.1);
	}
	
	@Test
	public void evalDivisionTest() throws DivisionParZeroException {
		assert(Operation.DIV.eval(1.2,2.1)==1.2/2.1);
	}
	
	@Test(expected=DivisionParZeroException.class)
	public void evalExceptionDivParZeroTest() throws DivisionParZeroException {
		Operation.DIV.eval(10,0);
	}
	
	@Test
	public void getOperationPlusTest() {
	    assertEquals(Operation.PLUS, Operation.getOperation('+'));
	}
	@Test
    public void getOperationMoinsTest() {
        assertEquals(Operation.MOINS, Operation.getOperation('-'));
    }
	@Test
    public void getOperationMultTest() {
        assertEquals(Operation.MULT, Operation.getOperation('*'));
    }
	@Test
    public void getOperationDivTest() {
        assertEquals(Operation.DIV, Operation.getOperation('/'));
    }
	
	@Test
	public void isOperateurTrueTest() {
	    assertTrue(Operation.isOperateur("+"));
	}
	@Test
    public void isOperateurFalseTest() {
        assertFalse(Operation.isOperateur("$"));
    }
	
	
}
