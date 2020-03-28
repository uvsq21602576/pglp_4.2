package fr.uvsq.uvsq21602576.pglp_4_2.exceptions;

/**
 * Exception.
 * Lancée en cas de commande inconnue.
 * @author Flora
 */
public class NoCommandException extends CalculatriceRPNException {

    /**
     * Constructeur.
     * Crée une exception avec comme message "No entry for"
     * Et le nom de la commande indiquée.
     * @param commande nom de la commande inconnue.
     */
    public NoCommandException(String commande) {
        super("No entry for \""+commande+"\"");
    }
}
