package fr.uvsq.uvsq21602576.pglp_4_2.exceptions;

/**
 * Exception.
 * Lancée en cas d'echec de l'annulation d'une commande.
 * @author Flora
 */
public class UndoImpossibleException extends CalculatriceRPNException {

    /**
     * Constructeur.
     * Le message décrit ce qui s'est mal passé à l'annulation de la commande.
     * @param message   Message
     */
    public UndoImpossibleException(String message) {
        super("Undo impossible à exécuter : "+message);
    }
}
