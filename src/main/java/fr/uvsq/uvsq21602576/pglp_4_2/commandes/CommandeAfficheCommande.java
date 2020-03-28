package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

import fr.uvsq.uvsq21602576.pglp_4_2.Interpreteur;

/**
 * Commande pour afficher les commandes disponibles.
 * @author Flora
 */
public class CommandeAfficheCommande implements Commande {

    /**
     * Interpreteur dans lequel elle est appelée.
     */
    private Interpreteur interpreteur;

    /**
     * COnstrcuteur.
     * Crée une Commande à partir de son Interpreteur.
     * @param i Interpreteur.
     */
    public CommandeAfficheCommande(final Interpreteur i) {
        this.interpreteur = i;
    }

    /**
     * Execution.
     * Affiche les commandes disponibles dans l'interpreteur.
     */
    public void execute() {
        System.out.println(interpreteur.afficheCommandes());
    }

}
