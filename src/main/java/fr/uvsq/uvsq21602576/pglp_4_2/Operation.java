package fr.uvsq.uvsq21602576.pglp_4_2;

import fr.uvsq.uvsq21602576.pglp_4_2.exceptions.DivisionParZeroException;

public enum Operation {
	PLUS ('+') {
		@Override
		public double eval(double a, double b) {
			double result;
			result = a+b;
			
			return result;
		}
	},
	MOINS ('-'){
		@Override
		public double eval(double a, double b) {
			double result;
			result = a-b;
			
			return result;
		}
	},
	MULT ('*'){
		@Override
		public double eval(double a, double b) {
			double result;
			result = a*b;
			
			return result;
		}
	},
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
	
	
	private char symbole;
	
	Operation(char c)
	{
		symbole = c;
	}
	
	/**
	 * Effectue le calcul entre a et b en fonction de l'Operation.
	 * @param a	double
	 * @param b	double
	 * @return	resultat du calcul de a et b
	 * @throws DivisionParZeroException
	 */
	public abstract double eval(double a, double b) throws DivisionParZeroException;
	
	public char getSymbole()
	{
	    return symbole;
	}
	
	public static Operation getOperation(char c) {
	    Operation o[] = Operation.values();
        for (int i = 0; i < o.length; i++) {
            if(o[i].getSymbole()==c) {
                return o[i];
            }
        }
        return null;
	}
	
	public static boolean isOperateur(String str) {
        Operation o[] = Operation.values();
        for (int i = 0; i < o.length; i++) {
            if(str.equals(String.valueOf(o[i].getSymbole()))) {
                return true;
            }
        }
        return false;
    }
}
