
/**
 * Beschreiben Sie hier die Klasse Event.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Event extends TimingSimulator
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private static EventQueue Q;//bezeichnet die dem Event zugeordnete EventQueue
    private Signal signal;
    private int time = 0; // in milliseconds
    private Boolean newValue = false; 

    public Event(Signal signal, int startTime, Boolean newValue)
    {
        this.signal = signal;
        time = startTime;
        this.newValue = newValue;
        
    }

    public static void setEventQueue(EventQueue newQueue)
    {
        Q = newQueue;
    }
    
    public void propagate(){
        
    }
}
