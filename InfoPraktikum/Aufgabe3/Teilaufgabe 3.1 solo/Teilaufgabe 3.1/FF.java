public class FF extends Gatter {

	/**
	 * Konstruktor für Unterklassen von Gatter
	 * 1.Konstruktor: Anzahl der Eingänge
	 * 2.Konstruktor:  Anzahl der Eingänge, Zeit die das Gatter zum reagieren braucht
	*/
	public FF(int waitTime) {
		super(2, waitTime);
	}

	/*
	 * laut wahrheitstabelle kann man einfach nur
	 * den  zweiten  wert betrachten
	 * beim  illegal state würden  theoretisch Q und notQ true werden,
	 * das kann  hier nicht realisiert werden, da nur Q zurückgegeben  wird
	 */
	public boolean calculate(boolean[] input) {
    	    return input[0];
	}

}