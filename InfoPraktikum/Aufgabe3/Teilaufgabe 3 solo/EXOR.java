public class EXOR extends Gatter {

	/**
	 * Konstruktor f�r UNterklassen von Gatter
	 * 1.Konstruktor: Anzahl der Eing�nge
	 * 2.Konstruktor:  Anzahl der Eing�nge, Zeit die das Gatter zum reagieren braucht
	*/
	public EXOR(int anzEin) {
		super(anzEin);
	}
	public EXOR(int anzEin, int waitTime) {
		super(anzEin, waitTime);
	}

	
	public boolean calculate(int trueAmount) {
    	    	return (trueAmount == 1);
	}

}