package fr.uvsq.uvsq21602576.pglp_4_2;

import java.util.HashMap;

import fr.uvsq.uvsq21602576.pglp_4_2.commandes.Commande;
import fr.uvsq.uvsq21602576.pglp_4_2.commandes.CommandeExit;
import fr.uvsq.uvsq21602576.pglp_4_2.commandes.CommandeUndo;
import fr.uvsq.uvsq21602576.pglp_4_2.commandes.CommandeUndoable;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.CommandeImpossibleException;

/**
 * Interpréteur.
 * Possède un tableau de commande pouvant être exécutée.
 * @author Flora
 */
public class Interpreteur {
    private Historique historique;
    private final HashMap<String, Commande> commandes;

	public Interpreteur() {
	    commandes = new HashMap<String, Commande>();
	    historique = new Historique();
        this.enregistre("undo", new CommandeUndo(historique));
        this.enregistre("exit", new CommandeExit());
	}

	protected void enregistre(String nom, Commande c) {
	    commandes.put(nom, c);
	}
	
	public Boolean execute(String nomCommande) {
	    if (this.commandes.containsKey(nomCommande)) {
	        Commande c = this.commandes.get(nomCommande);
	        return this.execute(c);
	    } else {
	        System.err.println("No entry for "+nomCommande);
	    }
	    return true;
	}

	public boolean execute(Commande c) {
	    try {
	        boolean enMarche = c.execute();
            if (c instanceof CommandeUndoable) {
                historique.ajoute((CommandeUndoable) c);
            }
            return enMarche;
        } catch (CommandeImpossibleException e) {
            System.err.println(e.getMessage());
        }
        return true;
	}
}
