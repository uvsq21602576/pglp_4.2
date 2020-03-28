package fr.uvsq.uvsq21602576.pglp_4_2;

import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.DivisionParZeroException;

/**
 * Enum représentant les différentes opérations disponibles.
 * @author Flora
 */
public enum Operation {
    /**
     * Addition.
     */
    PLUS ('+') {
        @Override
        public double eval(double a, double b) {
            double result;
            result = a+b;

            return result;
        }
    },
    /**
     * Soustraction.
     */
    MOINS ('-'){
        @Override
        public double eval(double a, double b) {
            double result;
            result = a-b;

            return result;
        }
    },
    /**
     * Multiplication.
     */
    MULT ('*'){
        @Override
        public double eval(double a, double b) {
            double result;
            result = a*b;

            return result;
        }
    },
    /**
     * Division.
     */
    DIV ('/'){
        @Override
        public double eval(double a, double b) throws DivisionParZeroException {
            double result = 0;
            if(b==0)
                throw new DivisionParZeroException();
            else
                result = a/b;

            return result;
        }
    };

    /**
     * Symbole de l'opération.
     */
    private char symbole;

    /**
     * Constructeur.
     * @param c    Symbole.
     */
    Operation(char c)
    {
        symbole = c;
    }

    /**
     * Effectue le calcul entre a et b en fonction de l'Operation.
     * @param a	double
     * @param b	double
     * @return	resultat du calcul de a et b
     * @throws DivisionParZeroException    En cas de division par zero.
     */
    public abstract double eval(double a, double b) throws DivisionParZeroException;

    /**
     * Retorune le symbole associé à l'opération.
     * @return Symbole de l'opération.
     */
    public char getSymbole()
    {
        return symbole;
    }

    /**
     * Retourne l'opération associé au symbole.
     * @param c    Symbole de l'opération.
     * @return Opération si existante, null sinon.
     */
    public static Operation getOperation(char c) {
        Operation o[] = Operation.values();
        for (int i = 0; i < o.length; i++) {
            if(o[i].getSymbole()==c) {
                return o[i];
            }
        }
        return null;
    }

    /**
     * Teste si la chaine de caractère représente une operation.
     * @param str  Chaine à tester.
     * @return true si Opération existe, false sinon.
     */
    public static boolean isOperateur(String str) {
        Operation o[] = Operation.values();
        for (int i = 0; i < o.length; i++) {
            if(str.equals(String.valueOf(o[i].getSymbole()))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retourne une représentation textuelle.
     * Sous forme de liste des opérateurs possibles.
     * @return liste d'opérateurs.
     */
    public static String afficheOperateurs() {
        Operation o[] = Operation.values();
        String s = "[";
        for (int i = 0; i < o.length; i++) {
            s = s.concat(o[i].symbole + ", ");
        }
        s = s.substring(0, s.length() - 2);
        s = s.concat("]");
        return s;
    }
}
