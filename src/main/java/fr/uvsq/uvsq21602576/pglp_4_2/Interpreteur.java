package fr.uvsq.uvsq21602576.pglp_4_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import fr.uvsq.uvsq21602576.pglp_4_2.commandes.Commande;
import fr.uvsq.uvsq21602576.pglp_4_2.commandes.CommandeAfficheCommande;
import fr.uvsq.uvsq21602576.pglp_4_2.commandes.CommandeExit;
import fr.uvsq.uvsq21602576.pglp_4_2.commandes.CommandeUndo;
import fr.uvsq.uvsq21602576.pglp_4_2.commandes.CommandeUndoable;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.CommandeImpossibleException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.NoCommandException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.UndoImpossibleException;

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
        this.enregistre("help", new CommandeAfficheCommande(this));
    }

    protected void enregistre(String nom, Commande c) {
        commandes.put(nom, c);
    }

    public Boolean execute(String nomCommande) throws NoCommandException, CommandeImpossibleException, UndoImpossibleException {
        if (this.commandes.containsKey(nomCommande)) {
            Commande c = this.commandes.get(nomCommande);
            return this.execute(c);
        } else {
            throw new NoCommandException(nomCommande);
        }
    }

    public boolean execute(Commande c) throws CommandeImpossibleException, UndoImpossibleException {
        boolean arret = c.execute();
        if (c instanceof CommandeUndoable) {
            historique.ajoute((CommandeUndoable) c);
        }
        return arret;
    }

    public List<String> keySet() {
        return Collections.unmodifiableList(new ArrayList<String>(commandes.keySet()));
    }

    public String afficheCommandes() {
        return commandes.keySet().toString();
    }
}
