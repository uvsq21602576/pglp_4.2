package fr.uvsq.uvsq21602576.pglp_4_2.exceptions;

public class OperandeAbsenteException extends CalculatriceRPNException {
    
    public OperandeAbsenteException() {
        super("Pas assez d'opérandes enregistrées "
                + "pour effectuer l'opération.");
    }

}
