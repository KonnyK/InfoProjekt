public class Buf extends Gatter {

	/**
	 * Konstruktor f�r Unterklassen von Gatter
	 * 1.Konstruktor: Anzahl der Eing�nge
	 * 2.Konstruktor:  Anzahl der Eing�nge, Zeit die das Gatter zum reagieren braucht
	*/
	public Buf(int waitTime) {
		super(1, waitTime);
	}

	/*
	 * gibt den  Eingangswert zur�ck
	 * bei mehreren  Eing�ngen  wird der Durchschnitt gebildet
	 * gleiche ANzahl an  true & false wird als false interpretiert
	 * um das zu �ndern: > zu >= �ndern
	 */
	public boolean calculate(boolean[] input) {
	    int trueAmount = 0;
	    for (boolean i:input) if (i) trueAmount++;
    	    return (trueAmount > input.length/2);
	}

}