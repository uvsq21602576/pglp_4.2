package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import fr.uvsq.uvsq21602576.pglp_4_2.Arret;

/**
 * Commande pour demander l'arret du programme.
 * @author Flora
 */
public class CommandeExit implements Commande {
    /**
     * Arret.
     * Stocke si e programme doit s'arreter ou non.
     */
    private Arret arret;

    /**
     * Constructeur.
     * Crée une commande avec l'arret.
     * @param arret2    Arret
     */
    public CommandeExit(Arret arret2) {
        this.arret = arret2;
    }

    /**
     * Previens l'arret du programme.
     * En modifiant Arret.
     */
    public void execute() {
        System.out.println("Exit");
        this.arret.setArret();
    }

}
