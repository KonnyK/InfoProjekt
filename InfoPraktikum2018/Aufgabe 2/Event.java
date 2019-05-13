
/**
 * Beschreiben Sie hier die Klasse Event.
 * 
 * @author (Konrad, Paul B. Vogt) 
 * @version (V4 12.06.18 18:50)
 */
public class Event
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private static EventQueue Q; //wieso static?
    private Signal signal;
    private int time = 0; // in milliseconds
    private boolean newValue = false; 

    public Event(Signal signal, int startTime, boolean newValue)
    {
        this.signal = signal;
        time = startTime;
        this.newValue = newValue;
        Q.addtoQueueandsort(this); //Probleme bei der Verknüpung mit diesem Event
    }

    public static void setEventQueue(EventQueue newQueue)
    //welchen zweck hat diese Methode?
    {
        Q = newQueue;
    }
    
    
    
    public void propagate(){
        
    }
}
