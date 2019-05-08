
/**
 * Beschreiben Sie hier die Klasse Event.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Event
{
    private static EventQueue queue;
    private Signal signal;
    private int time;
    private boolean newValue;
    
    
    public static EventQueue getQueue(){
         return Event.queue;
    }
    
    public Event(Signal signal, int time, boolean newValue){
        this.signal = signal;
        this.time = time;
        this.newValue = newValue;
        queue.add(this);
    }
    
    public void propagate(){
        signal.setInternValue(newValue);
    }
    
    public static void setEventQueue(EventQueue queue){
        Event.queue = queue;
    }
    
    public int getTime(){
        return time;
    }
    
    public void shortenTime(int amount){
        time -= amount;
    }
  
    
}
