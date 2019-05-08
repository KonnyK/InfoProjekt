public class Buf extends Gatter {

	/**
	 * Konstruktor für Unterklassen von Gatter
	 * 1.Konstruktor: Anzahl der Eingänge
	 * 2.Konstruktor:  Anzahl der Eingänge, Zeit die das Gatter zum reagieren braucht
	*/
	public Buf(int waitTime) {
		super(1, waitTime);
	}

	/*
	 * gibt den  Eingangswert zurück
	 * bei mehreren  Eingängen  wird der Durchschnitt gebildet
	 * gleiche ANzahl an  true & false wird als false interpretiert
	 * um das zu ändern: > zu >= ändern
	 */
	public boolean calculate(boolean[] input) {
	    int trueAmount = 0;
	    for (boolean i:input) if (i) trueAmount++;
    	    return (trueAmount > input.length/2);
	}

}