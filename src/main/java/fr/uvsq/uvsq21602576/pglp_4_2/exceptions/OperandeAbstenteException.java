package fr.uvsq.uvsq21602576.pglp_4_2.exceptions;

public class OperandeAbstenteException extends Exception {
    
    public OperandeAbstenteException() {
        super("Pas assez d'opérande enregistrée "
                + "pour effectuer l'opération.");
    }

}
