public class And extends Gatter {

	/**
	 * Konstruktor für UNterklassen von Gatter
	 * 1.Konstruktor: Anzahl der Eingänge
	 * 2.Konstruktor:  Anzahl der Eingänge, Zeit die das Gatter zum reagieren braucht
	*/
	public And(int anzEin) {
		super(anzEin);
	}
	public And(int anzEin, int waitTime) {
		super(anzEin, waitTime);
	}

	
	public boolean calculate(boolean[] input) {
	    int trueAmount = 0;
	    for (boolean i:input) if (i) trueAmount++;
    	    return (trueAmount >= input.length);
	}

}
