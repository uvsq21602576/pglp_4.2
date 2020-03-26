package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import fr.uvsq.uvsq21602576.pglp_4_2.MoteurRPN;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.CommandeImpossibleException;

public class CommandeAffiche implements Commande {
    private MoteurRPN moteur;
    
    public CommandeAffiche(MoteurRPN m) {
        this.moteur = m;
    }

    public boolean execute() {
        System.out.println(this.moteur.toString());
        return true;
    }

}
