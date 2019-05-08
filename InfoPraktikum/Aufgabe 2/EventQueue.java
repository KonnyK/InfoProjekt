
/**
 * Beschreiben Sie hier die Klasse EventQueue.
 * 
 * @author (Konrad, Paul B. Vogt) 
 * @version (V3 07.06.18 17:28)
 */
import java.util.ArrayList;
public class EventQueue
{
    
    ArrayList<Event> EventList = new ArrayList<Event>();
    //Arraylist mit dem Namen "Events" (Name sollte vieleicht geändert werden)
    public EventQueue()
    {
        
        
    }
    
    public void addtoQueueandsort(Event newEvent)
    /**noch zu testende Methode um neue Events in die Queue einzufügen 
     * und die Liste zu sortieren
     */
    {
        EventList.add(newEvent); //benötigt wohl noch eine EventID oä.
        
        
    
    }
    
    public boolean hasMore(){
        return !EventList.isEmpty();
    }
    
    public Event getFirst(){
        
        return EventList.get(0);
    }
   
}
