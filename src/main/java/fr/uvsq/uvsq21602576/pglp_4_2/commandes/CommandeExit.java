package fr.uvsq.uvsq21602576.pglp_4_2.commandes;

public class CommandeExit implements Commande {

    public CommandeExit() {
        
    }

    public boolean execute() {
        System.out.println("Exit");
        return false;
    }

}
