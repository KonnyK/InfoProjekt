import java.util.LinkedList;

public class EventQueue {
    private LinkedList<Event> events;
    private boolean started = false;
    private int time = 0;

    public EventQueue() {
        events = new LinkedList();
    }

    private void setTime(int newTime){
        if (newTime >= time) time =  Math.abs(newTime);
        else System.out.println("Trying to turn back time!");
    }

    public void addEvent(Event newEvent) {
        if (events.isEmpty()) events.add(newEvent);
        else{
        int i = 0;
        boolean indexFound = false;
        while (i < events.size() && !indexFound){
            if (events.get(i).equals(newEvent)) events.remove(i);
            if (events.get(i).getStartTime() > newEvent.getStartTime()) {indexFound = true;}
            else i++;
        }
        events.add(i, newEvent);
    }
    }

    public void removeEvent(Event e) {
        if (time < e.getStartTime()) setTime(e.getStartTime());
        events.remove(e);
        String  feedback=e.feedback();
        if (!feedback.contains("1") && !feedback.contains("2") &&!feedback.contains("3")  && !feedback.contains("4"))
            System.out.println( Integer.toString(time)  +  ": "   + e.feedback());
    }

    public boolean hasMore() {
        return !events.isEmpty();
    }

    public Event getFirst() {
        if (!started)  {started = true; System.out.println("Eventqueue started!");}
        return events.getFirst();
    }

    public int getPassedTime() {
        return time;
    }

    public boolean isStarted() {
        return started;
    }

    public void start() {
        started = true;
    }
    
    public int getListSize() {
        return events.size();
    }

}
