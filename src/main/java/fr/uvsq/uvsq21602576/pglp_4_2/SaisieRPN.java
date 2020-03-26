package fr.uvsq.uvsq21602576.pglp_4_2;

import java.util.Scanner;

public class SaisieRPN {

    private MoteurRPN moteur;

    public SaisieRPN() {
        this.moteur = new MoteurRPN();
    }
    
    private void interprete(String str) {
        moteur.execute(str);
    }
    
    public void lanceSaisie() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("# Entrer l'expression à calculer, "
                + "par mots de l'opération, ou \"undo\" pour revenir "
                + "en arrière ou \"exit\" pour quitter :");
        String str = "";
        while(!str.equals(".")) {
            str = sc.nextLine();
            interprete(str);
        }
        sc.close();
    }

}
