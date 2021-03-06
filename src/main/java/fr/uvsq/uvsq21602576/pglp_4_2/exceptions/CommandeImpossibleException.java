package fr.uvsq.uvsq21602576.pglp_4_2.exceptions;

/**
 * Exception.
 * Lancée en cas de commande impossible à effectuée.
 * @author Flora
 */
public class CommandeImpossibleException extends CalculatriceRPNException {

    /**
     * Constructeur.
     * Le message décrit ce qui s'est mal passé à l'exécution de la commande.
     * @param message   Message
     */
    public CommandeImpossibleException(final String message) {
        super("Commande impossible à executer : " + message);
    }
}
