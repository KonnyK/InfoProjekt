public class Not extends Gatter {

	/**
	 * Konstruktor f�r Unterklassen von Gatter
	 * 1.Konstruktor: Anzahl der Eing�nge
	 * 2.Konstruktor:  Anzahl der Eing�nge, Zeit die das Gatter zum reagieren braucht
	*/
	public Not(int waitTime) {
		super(1, waitTime);
	}

	/* bei mehreren Eing�ngen  wird  der Durchschnitt gebildet und  negiert
	 * wenn anzahl true = anzahl false z�hlt es als true und damit das 
	 * ergebnis = false  Um  das umzukehren m�sste man < zu <=  machen
	 */
	
	public boolean calculate(boolean[] input) {
	    int trueAmount = 0;
	    for (boolean i:input) if (i) trueAmount++;
    	    return (trueAmount < input.length/2);
	}

}