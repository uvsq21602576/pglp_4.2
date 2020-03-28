package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import fr.uvsq.uvsq21602576.pglp_4_2.Interpreteur;
import fr.uvsq.uvsq21602576.pglp_4_2.MoteurRPN;

/**
 * Teste le Commande AfficheCommande.
 * @author Flora
 */
public class CommandeAfficheCommandeTest {

    /**
     * Teste son execution avec un interpreteur.
     */
    @Test
    public void executeInterpreteurTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Interpreteur i = new Interpreteur(null);
        CommandeAfficheCommande c = new CommandeAfficheCommande(i);
        c.execute();

        System.setOut(System.out);
        String observed = outContent.toString().trim();

        assertEquals(i.afficheCommandes(), observed);
    }

    /**
     * Teste son execution avec un moteur.
     */
    @Test
    public void executeMoteurTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        MoteurRPN m = new MoteurRPN(null);
        CommandeAfficheCommande c = new CommandeAfficheCommande(m);
        c.execute();

        System.setOut(System.out);
        String observed = outContent.toString().trim();

        assertEquals(m.afficheCommandes(), observed);
    }
}
