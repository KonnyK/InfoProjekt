/**
 * Die abstrakte Klasse Gatter stellt die Superklasse f�r alle m�glichen Formen
 * von Gattern zur Verf�gung.
 * 
 * @author Nils-Team
 * @version 1.02 17.06.06
 */

public abstract class Gatter {
    protected Signal[] inputs;
    private Signal output;
    protected int delay;

    public Gatter(int amount) {
        inputs = new Signal[amount];
    }
     
    public Gatter(int amount, int delay) {
        this.delay = delay;
        inputs = new Signal[amount];
    }

    public void setInput(int index, Signal signal) {
        signal.addOutput(this);
        inputs[index] = signal;
    }

    public void setOutput(Signal signal) {
        output = signal;
    }
    
    public void refreshOutput(){
        int trueAmount = 0;//anzahl an wahren inputs
        for (Signal s:inputs) if (s.getValue()) trueAmount++;
        boolean  result = calculate(trueAmount);
        if (result != output.getValue()){
            if (Event.getEventQueue().isStarted()) new Event(output, Event.getEventQueue().getPassedTime() + delay, result);
            else  output.setValue(result);
        }

    }
    
    public boolean getOutputValue() {
        return output.getValue();
    }

    abstract boolean calculate(int trueAmount);
}
