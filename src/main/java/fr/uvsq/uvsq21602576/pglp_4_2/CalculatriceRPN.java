package fr.uvsq.uvsq21602576.pglp_4_2;

public enum CalculatriceRPN {
    MAIN;

    public void run() {
        Interpreteur i = Interpreteur.init();
        i.execute("undo");
        i.execute("exit");
    }

    public static void main() {
        MAIN.run();
    }
}
