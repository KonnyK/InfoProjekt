public class Not extends Gatter {

	/**
	 * Konstruktor für Unterklassen von Gatter
	 * 1.Konstruktor: Anzahl der Eingänge
	 * 2.Konstruktor:  Anzahl der Eingänge, Zeit die das Gatter zum reagieren braucht
	*/
	public Not(int waitTime) {
		super(1, waitTime);
	}

	/* bei mehreren Eingängen  wird  der Durchschnitt gebildet und  negiert
	 * wenn anzahl true = anzahl false zählt es als true und damit das 
	 * ergebnis = false  Um  das umzukehren müsste man < zu <=  machen
	 */
	
	public boolean calculate(boolean[] input) {
	    int trueAmount = 0;
	    for (boolean i:input) if (i) trueAmount++;
    	    return (trueAmount < input.length/2);
	}

}