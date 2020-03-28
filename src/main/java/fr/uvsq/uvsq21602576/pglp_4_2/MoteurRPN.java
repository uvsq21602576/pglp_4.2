package fr.uvsq.uvsq21602576.pglp_4_2;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import fr.uvsq.uvsq21602576.pglp_4_2.commandes.Commande;
import fr.uvsq.uvsq21602576.pglp_4_2.commandes.CommandeAfficheMoteur;
import fr.uvsq.uvsq21602576.pglp_4_2.commandes.CommandeAjoutOperande;
import fr.uvsq.uvsq21602576.pglp_4_2.commandes.CommandeOperation;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.CommandeImpossibleException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.NoCommandException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.OperandeAbsenteException;
import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.UndoImpossibleException;

/**
 * Représente un Moteur.
 * Stocke les opérandes et effectue des operations.
 * @author Flora
 */
public class MoteurRPN extends Interpreteur {
    /**
     * Pile d'opérandes.
     */
    private Stack<Double> operandes;

    /**
     * Constructeur.
     * Initialise un moteurRPN avec les commandes :
     * <ul>
     * <li>undo : annule la dernière commande effectuée.</li>
     * <li>exit : termine le programme. (Utilise arret)</li>
     * <li>help : affiche les commandes disponibles</li>
     * <li>affiche : affiche l'état de la pile</li>
     * </ul>
     * @param arret Pour signaler l'arret du programme.
     */
    public MoteurRPN(Arret arret){
        super(arret);
        operandes = new Stack<Double>();
        Commande affiche = new CommandeAfficheMoteur(this);
        super.enregistre("affiche", affiche);
    }

    /**
     * Enregistre la nouvelle opérande dans la pile du MoteurRPN.
     * @param a nouvelle opérande
     */
    public void enregistreOperande(double a) {
        operandes.push(a);
    }

    /**
     * Retire une opérandes de la pile et la retourne.
     * @return  dernière opérande.
     * @throws OperandeAbsenteException Si la pile est vide.
     */
    public double retireOperande() throws OperandeAbsenteException {
        if(operandes.isEmpty()) {
            throw new OperandeAbsenteException();
        }
        return operandes.pop();
    }

    /**
     * Retourne la pile d'opérandes.
     * Sous forme de liste non modifiable.
     * @return  Pile d'opérande non modifiable.
     */
    public List<Double> getOperandes() {
        return Collections.unmodifiableList(this.operandes);
    }

    /**
     * Ajoute une opérande au moteur.
     * Action annulable donc ajouté aussi dans l'historique.
     * @param o Opérande à ajouter
     * @throws CommandeImpossibleException  Si la commande est impossible.
     * @throws NoCommandException   Si la commande affiche n'existe pas.
     * @throws UndoImpossibleException  Si la commande undo échoue.
     */
    public void executeAjoutOperande(double o) throws CommandeImpossibleException, NoCommandException, UndoImpossibleException {
        Commande c = new CommandeAjoutOperande(this, o);
        super.execute(c);
        super.execute("affiche");
    }

    /**
     * Execute l'opération.
     * Action annulable donc ajouté aussi dans l'historique.
     * @param o Opérande à ajouter
     * @throws CommandeImpossibleException  Si la commande est impossible.
     * @throws NoCommandException   Si la commande affiche n'existe pas.
     * @throws UndoImpossibleException  Si la commande undo échoue.
     */
    public void executeOperation(Operation ope) throws CommandeImpossibleException, NoCommandException, UndoImpossibleException {
        Commande c = new CommandeOperation(this, ope);
        super.execute(c);
        super.execute("affiche");
    }

    /**
     * Renvoie un string.
     * Représentant la pile d'opérande.
     * @return  pile d'operande sous forme de String.
     */
    public String afficheOperandes() {
        return this.operandes.toString();
    }

    /**
     * Retourne une représentation textuelle.
     * Liste des commandes possibes.
     * @return  Representation textuelle des commandes possibles.
     */
    public String afficheCommandes() {
        String s = super.afficheCommandes();
        s = s.substring(0, s.length()-1);
        s = s.concat(",\n\t");
        String operateurs = Operation.afficheOperateurs();
        s = s.concat(operateurs.substring(1, operateurs.length() - 1));
        s = s.concat(",\n\tpour ajouter une opérande : écrivez-la simplement]");
        return s;
    }

}
