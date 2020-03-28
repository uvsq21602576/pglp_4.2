package fr.uvsq.uvsq21602576.pglp_4_2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArretTest {
    
    @Test
    public void constructeurTest() {
        Arret arret = new Arret();
        assertFalse(arret.isArret());
    }
    
    @Test
    public void setArretTest() {
        Arret arret = new Arret();
        arret.setArret();
        assertTrue(arret.isArret());
    }

}
