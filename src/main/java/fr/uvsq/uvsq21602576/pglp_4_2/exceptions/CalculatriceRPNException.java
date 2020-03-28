package fr.uvsq.uvsq21602576.pglp_4_2.exceptions;

/**
 * SuperClasse des exceptions.
 * Conerne les exception liée à la calculatrice.
 * @author Flora
 */
public class CalculatriceRPNException extends Exception{
    
    /**
     * Constructeur.
     * Crée l'exception à partir du message
     * la décrivant.
     * @param message   Message
     */
    public CalculatriceRPNException(String message) {
        super(message);
    }
}
