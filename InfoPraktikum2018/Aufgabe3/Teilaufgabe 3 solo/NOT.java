public class NOT extends Gatter {

	/**
	 * Konstruktor f�r Unterklassen von Gatter
	 * 1.Konstruktor: Anzahl der Eing�nge
	 * 2.Konstruktor:  Anzahl der Eing�nge, Zeit die das Gatter zum reagieren braucht
	*/
	public NOT(int waitTime) {
		super(1, waitTime);
	}

	
	public boolean calculate(int trueAmount) {
    	    	return !(trueAmount > 0);
	}

}