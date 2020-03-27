package fr.uvsq.uvsq21602576.pglp_4_2.exceptions;

public class DivisionParZeroException extends CalculatriceRPNException {
    public DivisionParZeroException () {
        super("Division par zéro.");
    }
}
