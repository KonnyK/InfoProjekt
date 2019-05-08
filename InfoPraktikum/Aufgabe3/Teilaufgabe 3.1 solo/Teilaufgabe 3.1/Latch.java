public class Latch extends Gatter {

    /**
     * Konstruktor für Unterklassen von Gatter
     * 1.Konstruktor: Anzahl der Eingänge
     * 2.Konstruktor:  Anzahl der Eingänge, Zeit die das Gatter zum reagieren braucht
    */
    public Latch(int waitTime) {
        super(2, waitTime);
    }

    
    public boolean calculate(boolean[] input) {
        
            if  (!input[0] && !input[1]) return false;
            if  (input[0] && !input[1]) return true;
            if  (!input[0] && input[1]) return false;
            if  (input[0] && input[1]) return false;
        return false;
    }

}