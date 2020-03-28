package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import fr.uvsq.uvsq21602576.pglp_4_2.MoteurRPN;

/**
 * Teste la commande afficheMoteur.
 * @author Flora
 */
public class CommandeAfficheMoteurTest {

    /**
     * Teste son execution.
     */
    @Test
    public void executeTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        MoteurRPN m = new MoteurRPN(null);
        m.enregistreOperande(3);
        m.enregistreOperande(3);
        CommandeAfficheMoteur c = new CommandeAfficheMoteur(m);
        c.execute();

        System.setOut(System.out);
        String observed = outContent.toString().trim();

        assertEquals(m.afficheOperandes(), observed);
    }
}
