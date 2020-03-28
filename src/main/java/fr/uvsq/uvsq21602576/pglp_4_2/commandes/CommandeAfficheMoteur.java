package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import fr.uvsq.uvsq21602576.pglp_4_2.MoteurRPN;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.CommandeImpossibleException;

/**
 * Commande pour afficher la pile d'opérande du moteur.
 * @author Flora
 */
public class CommandeAfficheMoteur implements Commande {
    /**
     * MoteurRPN dans lequel est elle est appelé.
     */
    private MoteurRPN moteur;
    
    /**
     * COnstructeur.
     * Crée la commande a partir de son moteur.
     * @param m Moteur.
     */
    public CommandeAfficheMoteur(MoteurRPN m) {
        this.moteur = m;
    }

    /**
     * Execution.
     * Affiche l'état de la pile du moteur.
     */
    public void execute() {
        System.out.println(this.moteur.afficheOperandes());
    }

}
