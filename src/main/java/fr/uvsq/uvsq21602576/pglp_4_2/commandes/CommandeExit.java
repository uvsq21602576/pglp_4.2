package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import fr.uvsq.uvsq21602576.pglp_4_2.Arret;

public class CommandeExit implements Commande {
    private Arret arret;

    public CommandeExit(Arret arret2) {
        this.arret = arret2;
    }

    public void execute() {
        System.out.println("Exit");
        this.arret.setArret();
    }

}
