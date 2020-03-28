package fr.uvsq.uvsq21602576.pglp_4_2.exceptions;

/**
 * Exception.
 * Lancée en cas de division par zero.
 * @author Flora
 */
public class DivisionParZeroException extends CalculatriceRPNException {

    /**
     * Constructeur.
     * Crée une exception avec comme message "Division par zero."
     */
    public DivisionParZeroException() {
        super("Division par zéro.");
    }
}
