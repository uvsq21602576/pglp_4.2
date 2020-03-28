package fr.uvsq.uvsq21602576.pglp_4_2;

/**
 * Singleton Calculatrice.
 * Représente une calculatriceRPN.
 * Contient le main.
 * @author Flora
 *
 */
public enum CalculatriceRPN {
    /** Main.
     * Pour lancer la calculatrice.
     */
    MAIN;

    /**
     * Méthode lançant la calculatrice.
     */
    public void run() {
        SaisieRPN s = new SaisieRPN();
        s.lanceSaisie();
    }

    /**
     * Main.
     * @param args arguments de la ligne de commande
     */
    public static void main(final String[] args) {
        MAIN.run();
    }
}
