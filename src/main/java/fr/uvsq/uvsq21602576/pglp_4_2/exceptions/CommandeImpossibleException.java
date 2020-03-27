package fr.uvsq.uvsq21602576.pglp_4_2.exceptions;

public class CommandeImpossibleException extends CalculatriceRPNException {

    public CommandeImpossibleException(String message) {
        super("Commande impossible à executer : "+message);
    }
}
