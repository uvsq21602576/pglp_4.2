package fr.uvsq.uvsq21602576.pglp_4_2;

public enum CalculatriceRPN {
    MAIN;

    public void run() {
        /*Interpreteur i = new Interpreteur();
        i.execute("undo");
        i.execute("exit");*/
        SaisieRPN s = new SaisieRPN();
        s.lanceSaisie();
    }

    public static void main(String args[]) {
        MAIN.run();
    }
}
