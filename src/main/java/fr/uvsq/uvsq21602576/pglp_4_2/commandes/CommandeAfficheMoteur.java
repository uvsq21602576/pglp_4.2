package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import fr.uvsq.uvsq21602576.pglp_4_2.MoteurRPN;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.CommandeImpossibleException;

public class CommandeAfficheMoteur implements Commande {
    private MoteurRPN moteur;
    
    public CommandeAfficheMoteur(MoteurRPN m) {
        this.moteur = m;
    }

    public void execute() {
        System.out.println(this.moteur.afficheOperandes());
    }

}
