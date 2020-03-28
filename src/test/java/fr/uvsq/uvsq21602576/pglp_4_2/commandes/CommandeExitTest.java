package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.uvsq.uvsq21602576.pglp_4_2.Arret;

public class CommandeExitTest {

    @Test
    public void executeTest() {
        Arret arret = new Arret();
        CommandeExit exit = new CommandeExit(arret);
        exit.execute();
        assertTrue(arret.isArret());
    }
}
