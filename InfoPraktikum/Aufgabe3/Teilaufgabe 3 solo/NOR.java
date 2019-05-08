public class NOR extends Gatter {

	/**
	 * Konstruktor f�r UNterklassen von Gatter
	 * 1.Konstruktor: Anzahl der Eing�nge
	 * 2.Konstruktor:  Anzahl der Eing�nge, Zeit die das Gatter zum reagieren braucht
	*/
	public NOR(int anzEin) {
		super(anzEin);
	}
	public NOR(int anzEin, int waitTime) {
		super(anzEin, waitTime);
	}

	
	public boolean calculate(int trueAmount) {
    	    	return !(trueAmount > 0);
	}

}