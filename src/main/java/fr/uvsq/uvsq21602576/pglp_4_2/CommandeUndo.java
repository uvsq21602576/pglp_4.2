package fr.uvsq.uvsq21602576.pglp_4_2;

/**
 * Commande pour annuler la dernière commande faite.
 * @author Flora
 */
public class CommandeUndo implements Commande {

    public CommandeUndo() {
    }

    public void execute() {
        System.out.println("Undo");
    }

}
