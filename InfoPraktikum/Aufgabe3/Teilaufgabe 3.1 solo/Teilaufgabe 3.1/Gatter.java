/**
 * Die abstrakte Klasse Gatter stellt die Superklasse für alle möglichen Formen
 * von Gattern zur Verfügung.
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
        boolean[] in  = new boolean[inputs.length];
        for (int i = 0; i < inputs.length; i++) in[i] = inputs[i].getValue();
        boolean  result = calculate(in);
        if (result != output.getValue()){
            if (Event.getEventQueue().isStarted()) new Event(output, Event.getEventQueue().getPassedTime() + delay, result);
            else  output.setValue(result);
        }

    }
    
    public boolean getOutputValue() {
        return output.getValue();
    }

    abstract boolean calculate(boolean[] inputs);
}
