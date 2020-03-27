package fr.uvsq.uvsq21602576.pglp_4_2;

import org.junit.Test;

import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.DivisionParZeroException;

public class OperationTest {
	
	@Test
	public void testPlus() throws DivisionParZeroException {
		assert(Operation.PLUS.eval(1.2,2.1)==1.2+2.1);
	}
	
	@Test
	public void testMoins() throws DivisionParZeroException {
		assert(Operation.MOINS.eval(1.2,2.1)==1.2-2.1);
	}
	
	@Test
	public void testMult() throws DivisionParZeroException {
		assert(Operation.MULT.eval(1.2,2.1)==1.2*2.1);
	}
	
	@Test
	public void testDiv() throws DivisionParZeroException {
		assert(Operation.DIV.eval(1.2,2.1)==1.2/2.1);
	}
	
	@Test(expected=DivisionParZeroException.class)
	public void TestDivParZero() throws DivisionParZeroException {
		Operation.DIV.eval(10,0);
	}
}
