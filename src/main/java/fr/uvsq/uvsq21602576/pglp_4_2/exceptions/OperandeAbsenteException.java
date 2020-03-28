package fr.uvsq.uvsq21602576.pglp_4_2.exceptions;

/**
 * Exception.
 * Lancée lorsque qu'une opération en peut s'effectuer,
 * faute d'opérandes.
 * @author Flora
 */
public class OperandeAbsenteException extends CalculatriceRPNException {

    /**
     * Constructeur.
     * Crée une exception avec comme message
     * "Pas assez d'opérandes enregistrées
     *  pour effectuer l'opération."
     */
    public OperandeAbsenteException() {
        super("Pas assez d'opérandes enregistrées "
                + "pour effectuer l'opération.");
    }

}
