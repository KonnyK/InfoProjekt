import java.util.ArrayList;

public class Signal {
    private String name;
    private boolean value;
    private ArrayList<Gatter> outputs;
    
    public Signal(String newName) {
        this.name = newName;
        outputs = new ArrayList ();
        }
    
    public void setValue (boolean value) {
        this.value = value;
        for (Gatter out:outputs) out.refreshOutput();
        
        //Debug hilfe
        //System.out.println(name + "=>" + value + " (" + Event.getEventQueue().isStarted() +  ")");
    }
    public void addOutput (Gatter newGatter) {
        outputs.add(newGatter);
    }
    public boolean getValue (){
        return value;
    }
    public String getName (){
        return name;
    }

    private void ausgabe() {
        // von hier aus sollte später auch in dateien geschrieben werden...
        // Dabei muss beachtet werden, ob man sich noch in der
        // Initialisierungsphase
        // befindet (evtListe.isStarted())
        /*
         * //Ausgabe von Eingängen: if (gatterListe.size() == 1) {
         * System.out.println("E: " + Event.getEventQueue().getRunTime() + " " +
         * this.name + " = " + this.wert); }
         */
        // Ausgabe von Ausgängen:
        if (outputs.isEmpty()) {
            System.out.println("A: " + Event.getEventQueue().getPassedTime() + " "
                    + name + " = " + value);
        } else { //eingefügt wegen Teilaufgabe 3
            if ( (name.contains("Out")) || (name.contains("out")) ) { 
                System.out.println("A: " + Event.getEventQueue().getPassedTime() + " "
                        + name + " = " + value);
            }
        }
    }
}
