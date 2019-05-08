public class FF extends Gatter {

	/**
	 * Konstruktor f�r Unterklassen von Gatter
	 * 1.Konstruktor: Anzahl der Eing�nge
	 * 2.Konstruktor:  Anzahl der Eing�nge, Zeit die das Gatter zum reagieren braucht
	*/
	public FF(int waitTime) {
		super(2, waitTime);
	}

	/*
	 * laut wahrheitstabelle kann man einfach nur
	 * den  zweiten  wert betrachten
	 * beim  illegal state w�rden  theoretisch Q und notQ true werden,
	 * das kann  hier nicht realisiert werden, da nur Q zur�ckgegeben  wird
	 */
	public boolean calculate(boolean[] input) {
    	    return input[0];
	}

}