
/**
 * Beschreiben Sie hier die Klasse EventQueue.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.*;
import java.util.concurrent.TimeUnit;
public class EventQueue
{
    private LinkedList<Event> events;
    private int passedEventAmount = 0;
    
    public EventQueue(){
        events = new LinkedList<Event>();
    }
    
    public boolean hasMore(){
        
        passedEventAmount++;
        if (passedEventAmount > 300) {
            System.out.println("More than 300 Events happened!");
            System.out.println("Stopping...");
            return false;
        }
        
        if (events.size() == 0) return false;
        else return true;
    }
    
    public Event getFirst(){
        Event e = events.get(0);
        events.remove();
        try {
            TimeUnit.MILLISECONDS.sleep(e.getTime());
        } catch (InterruptedException x){ }
        for (int i = 0; i < events.size(); i++) events.get(i).shortenTime(e.getTime()); 
        return e;
    }
    
    public void add(Event newEvent){
        events.add(newEvent);
        int i = 0;
        while (i < events.size()-1 & events.get(i).getTime() <= newEvent.getTime()) i++;
        if (i == events.size()) events.add(newEvent);
        else events.add(i, newEvent);
    }
    
    public void printevents(){
        System.out.println(events);
    }
}
