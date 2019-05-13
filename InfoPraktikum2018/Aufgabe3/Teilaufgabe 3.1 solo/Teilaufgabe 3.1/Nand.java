public class Nand extends Gatter {
    
	/**
	 * Konstruktor f�r UNterklassen von Gatter
	 * 1.Konstruktor: Anzahl der Eing�nge
	 * 2.Konstruktor:  Anzahl der Eing�nge, Zeit die das Gatter zum reagieren braucht
	*/
	public Nand(int anzEin) {
		super(anzEin);
	}
	public Nand(int anzEin, int waitTime) {
		super(anzEin, waitTime);
	}

	
	public boolean calculate(boolean[] input) {
	    int trueAmount = 0;
	    for (boolean i:input) if (i) trueAmount++;
    	    return (input.length > trueAmount);
	}
}
