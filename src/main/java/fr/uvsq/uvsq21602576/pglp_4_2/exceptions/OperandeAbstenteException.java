package fr.uvsq.uvsq21602576.pglp_4_2.exceptions;

public class OperandeAbstenteException extends CalculatriceRPNException {
    
    public OperandeAbstenteException() {
        super("Pas assez d'opérande enregistrée "
                + "pour effectuer l'opération.");
    }

}
