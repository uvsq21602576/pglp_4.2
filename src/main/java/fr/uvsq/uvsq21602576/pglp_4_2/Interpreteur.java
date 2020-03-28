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
    /**
     * Historique de commandes annulables.
     */
    private Historique historique;
    /**
     * Tableau de commandes possibles.
     */
    private final HashMap<String, Commande> commandes;

    /**
     * Constructeur.
     * Crée un interpréteur avec les commandes :
     * <ul>
     * <li>undo : annule la dernière commande effectuée.</li>
     * <li>exit : termine le programme. (Utilise arret)</li>
     * <li>help : affiche les commandes disponibles</li>
     * </ul>
     * @param arret Pour signaler l'arret du programme.
     */
    public Interpreteur(Arret arret) {
        commandes = new HashMap<String, Commande>();
        historique = new Historique();
        this.enregistre("undo", new CommandeUndo(historique));
        this.enregistre("exit", new CommandeExit(arret));
        this.enregistre("help", new CommandeAfficheCommande(this));
    }

    /**
     * Enregistre une nouvelle commande nom.
     * @param nom   Nom de la commande
     * @param c Commande
     */
    protected void enregistre(String nom, Commande c) {
        commandes.put(nom, c);
    }

    /**
     * Execute une commande.
     * La commande enregistrée sous le nom nomCommande.
     * @param nomCommande   nom de la commande
     * @throws NoCommandException   Si la commande n'existe pas.
     * @throws CommandeImpossibleException  Si la commande est
     *      impossible a effectuer.
     * @throws UndoImpossibleException  Si la commande undo a été
     *      impossible a effectuer.
     */
    public void execute(String nomCommande)
            throws NoCommandException, CommandeImpossibleException,
                UndoImpossibleException {
        if (this.commandes.containsKey(nomCommande)) {
            Commande c = this.commandes.get(nomCommande);
            this.execute(c);
        } else {
            throw new NoCommandException(nomCommande);
        }
    }

    /**
     * Execute la commande en parametre.
     * @param c Commande à executer
     * @throws CommandeImpossibleException Si la commande est
     *      impossible a effectuer.
     * @throws UndoImpossibleException Si la commande undo a été
     *      impossible a effectuer.
     */
    public void execute(Commande c) throws CommandeImpossibleException,
        UndoImpossibleException {
        c.execute();
        if (c instanceof CommandeUndoable) {
            historique.ajoute((CommandeUndoable) c);
        }
    }

    /**
     * Retourne la liste des noms de commandes.
     * Sous forme de liste non modifiable.
     * @return
     */
    public List<String> keySet() {
        return Collections.unmodifiableList(
                new ArrayList<String>(commandes.keySet()));
    }

    /**
     * Retourne une représentation textuelle.
     * Liste des commandes possibes.
     * @return  Representation textuelle des commandes possibles.
     */
    public String afficheCommandes() {
        return commandes.keySet().toString();
    }

    /**
     * Retourne l'historique.
     * @return  Historique
     */
    public List<CommandeUndoable> getHistorique() {
        return historique.getHistorique();
    }
}
