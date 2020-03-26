package fr.uvsq.uvsq21602576.pglp_4_2.exceptions;

public class UndoImpossibleException extends Exception {

    public UndoImpossibleException(String message) {
        super("Undo impossible à exécuter : "+message);
    }
}
