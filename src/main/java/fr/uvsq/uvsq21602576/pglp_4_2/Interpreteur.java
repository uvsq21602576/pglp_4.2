package fr.uvsq.uvsq21602576.pglp_4_2;

import java.util.HashMap;

/**
 * Interpréteur.
 * Possède un tableau de commande pouvant être exécutée.
 * @author Flora
 */
public class Interpreteur {
    private final HashMap<String, Commande> commandes;

	public Interpreteur() {
	    commandes = new HashMap<String, Commande>();
        this.enregistre("undo", new CommandeUndo());
        this.enregistre("exit", new CommandeExit());
	}

	protected void enregistre(String nom, Commande c) {
	    commandes.put(nom, c);
	}
	
	public void execute(String nomCommande) {
	    if(this.commandes.containsKey(nomCommande)) {
	        this.commandes.get(nomCommande).execute();
	    } else {
	        System.err.println("No entry for "+nomCommande);
	    }
	}
}
