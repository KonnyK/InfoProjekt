public class Event {
	private static EventQueue queue;
	private Signal targetSignal;
	private int startTime;
	private boolean newValue;
	
	public Event(Signal targetSignal, int startTime, boolean newValue) {
		this.targetSignal = targetSignal;
		this.startTime = startTime;
		this.newValue = newValue;
		queue.addEvent(this);
	}
	
	public static void setEventQueue(EventQueue newQueue) {
		queue = newQueue;
	}

	public static EventQueue getEventQueue() {
		return queue;
	}
	
	public void propagate() {
		//zu testzwecken:
		//System.out.println("Event: " + this.toString());
		//if (!queue.isStarted()) queue.start();
		queue.removeEvent(this);
		targetSignal.setValue(newValue);
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	public Signal getSignal() {
		return targetSignal;
	}
	
	public boolean getValue() {
		return newValue;
	}

	public boolean equals(Event e){
		return (e.getSignal()  ==  targetSignal  && e.getStartTime() ==  startTime && e.getValue() ==  newValue);
	}

	public String feedback() {
		return ("Signal " + targetSignal.getName() + " => " + newValue);
	}
}
