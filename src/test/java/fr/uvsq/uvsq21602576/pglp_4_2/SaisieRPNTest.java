package fr.uvsq.uvsq21602576.pglp_4_2;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Teste SaisieRPN.
 * @author Flora
 */
public class SaisieRPNTest {

    /**
     * Prend un tableau de chaine de caractère.
     * Et trim chacune de celles-ci.
     * Renvoie le tableau ainsi modifié.
     * @param s tableau de String
     * @return  tableau de String trimed
     */
    private String[] trim(final String[] s) {
        for (int i = 0; i < s.length; i++) {
            s[i] = s[i].trim();
        }
        return s;
    }

    /**
     * Teste la saisie.
     * En cas d'une seule opérande ajoutée.
     */
    @Test
    public void saisieOperande1Test() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String input = "0\n" + "exit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        SaisieRPN s = new SaisieRPN();
        s.lanceSaisie();

        String[] observed = outContent.toString().split("\n");
        observed = trim(observed);
        assertEquals("[" + 0. + "]", observed[1]);
    }

    /**
     * Teste la saisie.
     * En cas de deux opérandes ajoutées.
     */
    @Test
    public void saisieOperande2Test() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String input = "0\n" + "9.1\n" + "exit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        SaisieRPN s = new SaisieRPN();
        s.lanceSaisie();

        String[] observed = outContent.toString().trim().split("\n");
        observed = trim(observed);
        assertEquals("[" + 0. + ", " + 9.1 + "]", observed[2]);
    }

    /**
     * Teste la saisie.
     * En cas d'une opération.
     */
    @Test
    public void saisieOperationTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String input = "1\n" + "9.1\n" + "+\n" + "exit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        SaisieRPN s = new SaisieRPN();
        s.lanceSaisie();

        String[] observed = outContent.toString().trim().split("\n");
        observed = trim(observed);
        assertEquals("[" + 10.1 + "]", observed[3]);
    }

    /**
     * Teste la saisie.
     * En cas d'une commande.
     */
    @Test
    public void saisieCommandeTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String input = "1\n" + "9.1\n" + "affiche\n" + "exit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        SaisieRPN s = new SaisieRPN();
        s.lanceSaisie();

        String[] observed = outContent.toString().trim().split("\n");
        observed = trim(observed);
        assertEquals("[" + 1. + ", " + 9.1 + "]", observed[3]);
    }

    /**
     * Teste la saisie.
     * En cas d'une commande non existante.
     */
    @Test
    public void saisieCommandeExceptionTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));

        String input = "1\n" + "9.1\n" + "test\n" + "exit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        SaisieRPN s = new SaisieRPN();
        s.lanceSaisie();

        String[] observed = outContent.toString().trim().split("\n");
        observed = trim(observed);
        assertEquals("[" + 1. + ", " + 9.1 + "]", observed[2]);
        observed = errContent.toString().trim().split("\n");
        observed = trim(observed);
        assertEquals("No entry for \"test\"", observed[0]);
    }
}
