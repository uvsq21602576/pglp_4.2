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

public class MoteurRPN extends Interpreteur {
    private Stack<Double> operandes;

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
    
    public double retireOperande() throws OperandeAbsenteException {
        if(operandes.isEmpty()) {
            throw new OperandeAbsenteException();
        }
        return operandes.pop();
    }
    
    public List<Double> getOperandes() {
        return Collections.unmodifiableList(this.operandes);
    }
    
    public void executeAjoutOperande(double o) throws CommandeImpossibleException, NoCommandException, UndoImpossibleException {
        Commande c = new CommandeAjoutOperande(this, o);
        super.execute(c);
        super.execute("affiche");
    }
    
    public void executeOperation(Operation ope) throws CommandeImpossibleException, NoCommandException, UndoImpossibleException {
        Commande c = new CommandeOperation(this, ope);
        super.execute(c);
        super.execute("affiche");
    }
    
    public String afficheOperandes() {
        return this.operandes.toString();
    }
    
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
