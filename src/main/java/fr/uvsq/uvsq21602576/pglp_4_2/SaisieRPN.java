package fr.uvsq.uvsq21602576.pglp_4_2;

import java.util.Scanner;

import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.CalculatriceRPNException;

/**
 * Classe gérant l'interaction avec l'utilisateur.
 * @author Flora
 */
public class SaisieRPN {

    /**
     * Moteur RPN.
     */
    private MoteurRPN moteur;
    /**
     * Arret.
     * Stocke si le programme doit s'arreter ou non.
     */
    private Arret arret;

    /**
     * Constructeur.
     * Crée une saisie.
     */
    public SaisieRPN() {
        this.arret = new Arret();
        this.moteur = new MoteurRPN(arret);
    }

    /**
     * Teste si une chaine de caractère répresente un Double.
     * Un double peut commencer par '+' ou '-',
     * continuer sur des chiffres, avoir une virgule '.',
     * finir par des chiffres.
     * @param s chaine de caractère à tester
     * @return  TRUE si s représente un Double et FALSE sinon
     */
    private boolean isDouble(final String s) {
        if (s.isEmpty()) {
            return false;
        }
        int indice = 0;
        String nombre = "1234567890";
        if (s.length() != 1
                && (s.charAt(indice) == '-'
                || s.charAt(indice) == '+')) {
            indice++;
        }
        while (indice < s.length()
                && nombre.contains(String.valueOf(s.charAt(indice)))) {
            indice++;
        }
        if (indice < s.length() && s.length() != 1 && s.charAt(indice) == '.') {
            indice++;
        }
        while (indice < s.length()
                && nombre.contains(String.valueOf(s.charAt(indice)))) {
            indice++;
        }
        if (indice == s.length()) {
            return true;
        }
        return false;
    }

    /**
     * Interprete une saisie de l'utilisateur.
     * Peut être une commande, un opérateur, ou une opérande.
     * @param str   saisie de l'utilisateur.
     */
    private void interprete(final String str) {
        if (isDouble(str)) {
            try {
                moteur.executeAjoutOperande(Double.parseDouble(str));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else if (Operation.isOperateur(str)) {
            try {
                moteur.executeOperation(Operation.getOperation(str.charAt(0)));
            } catch (CalculatriceRPNException e) {
                System.err.println(e.getMessage());
            }
        } else {
            try {
                moteur.execute(str);
            } catch (CalculatriceRPNException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Commence l'interaction avec l'utilisateur.
     */
    public void lanceSaisie() {
        Scanner sc = new Scanner(System.in);

        System.out.println("# Entrer l'expression à calculer, "
                + "par mots de l'opération, ou \"undo\" pour revenir "
                + "en arrière ou \"exit\" pour quitter :");
        String str = "";
        //boolean arret = false;
        while (!arret.isArret()) {
            str = sc.nextLine();
            interprete(str);
        }
        sc.close();
    }

}
