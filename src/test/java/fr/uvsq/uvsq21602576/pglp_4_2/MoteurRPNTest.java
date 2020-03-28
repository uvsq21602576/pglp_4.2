package fr.uvsq.uvsq21602576.pglp_4_2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.OperandeAbsenteException;

public class MoteurRPNTest {
    
    @Test
    public void constructeurTest() {
        MoteurRPN m = new MoteurRPN(null);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("exit");
        expected.add("help");
        expected.add("affiche");
        expected.add("undo");
        assertEquals(expected, m.keySet());
        assertTrue(m.getOperandes().isEmpty());
    }
    
    @Test
    public void enregistreOperandeTest() {
        MoteurRPN m = new MoteurRPN(null);
        m.enregistreOperande(3);
        Stack<Double> expected = new Stack<>();
        expected.push(3.);
        assertEquals(expected, m.getOperandes());
    }
    
    @Test
    public void retireOperandeTest() throws OperandeAbsenteException {
        MoteurRPN m = new MoteurRPN(null);
        m.enregistreOperande(3);
        double observed = m.retireOperande();
        assertEquals(3., observed, 0);
        assertTrue(m.getOperandes().isEmpty());
    }
    
    @Test(expected=OperandeAbsenteException.class)
    public void retireOperandeExpectionVideTest() throws OperandeAbsenteException {
        MoteurRPN m = new MoteurRPN(null);
        m.retireOperande();
    }
    
    @Test
    public void afficheCommandeTest() {
        MoteurRPN i = new MoteurRPN(null);
        String expected = "[exit, help, affiche, undo,";
        String operateur = Operation.afficheOperateurs();
        expected = expected.concat("\n\t"+operateur.substring(1,operateur.length()-1));
        expected = expected.concat(",\n\tpour ajouter une opérande : écrivez-la simplement]");
        assertEquals(expected, i.afficheCommandes());
    }
    
    @Test
    public void afficheOperandesTest() {
        MoteurRPN m = new MoteurRPN(null);
        double a = 3;
        m.enregistreOperande(a);
        m.enregistreOperande(a);
        String expected = "[" + a + ", " + a + "]";
        assertEquals(expected, m.afficheOperandes());
    }
}
