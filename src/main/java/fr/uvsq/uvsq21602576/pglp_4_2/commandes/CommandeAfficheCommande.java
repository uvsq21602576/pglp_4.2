package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import fr.uvsq.uvsq21602576.pglp_4_2.Interpreteur;

public class CommandeAfficheCommande implements Commande {

    private Interpreteur interpreteur;
    
    public CommandeAfficheCommande(Interpreteur i) {
        this.interpreteur = i;
    }
    
    public void execute() {
        System.out.println(interpreteur.afficheCommandes());
    }

}
