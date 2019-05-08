public class NOT extends Gatter {

	/**
	 * Konstruktor für Unterklassen von Gatter
	 * 1.Konstruktor: Anzahl der Eingänge
	 * 2.Konstruktor:  Anzahl der Eingänge, Zeit die das Gatter zum reagieren braucht
	*/
	public NOT(int waitTime) {
		super(1, waitTime);
	}

	
	public boolean calculate(int trueAmount) {
    	    	return !(trueAmount > 0);
	}

}