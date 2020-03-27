package fr.uvsq.uvsq21602576.pglp_4_2.exceptions;

public class NoCommandException extends CalculatriceRPNException {

    public NoCommandException(String commande) {
        super("No entry for \""+commande+"\"");
    }
}
