package fr.uvsq.uvsq21602576.pglp_4_2;

import java.util.Scanner;

public class SaisieRPN {

    private MoteurRPN moteur;

    public SaisieRPN() {
        this.moteur = new MoteurRPN();
    }
    
    /**
     * Teste si une chaine de caractère répresente un Double.
     * Un double peut commencer par '+' ou '-', continuer sur des chiffres, avoir une virgule '.', finir par des chiffres. 
     * @param s chaine de caractère à tester
     * @return  TRUE si s représente un Double et FALSE sinon
     */
    private boolean isDouble(String s) {
        if(s.isEmpty())
            return false;
        
        int indice = 0;
        String nombre ="1234567890";
        if(s.length()!=1 && (s.charAt(indice)=='-' || s.charAt(indice)=='+')) {
            indice++;
        }
        while(indice<s.length() && nombre.contains(String.valueOf(s.charAt(indice)))) {
            indice++;
        }
        if(indice<s.length() && s.length()!=1 && s.charAt(indice)=='.') {
            indice++;
        }
        while(indice<s.length() && nombre.contains(String.valueOf(s.charAt(indice)))) {
            indice++;
        }
        if(indice==s.length())
            return true;
        return false;
    }
    
    
    private boolean interprete(String str) {
        if(isDouble(str)) {
            moteur.executeAjoutOperande(Double.parseDouble(str));
        } else if (Operation.isOperateur(str)) {
            moteur.executeOperation(Operation.getOperation(str.charAt(0)));
        } else {
            return moteur.execute(str);
        }
        return false;
    }
    
    public void lanceSaisie() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("# Entrer l'expression à calculer, "
                + "par mots de l'opération, ou \"undo\" pour revenir "
                + "en arrière ou \"exit\" pour quitter :");
        String str = "";
        boolean arret = false;
        while(!arret) {
            str = sc.nextLine();
            arret = interprete(str);
        }
        sc.close();
    }

}
