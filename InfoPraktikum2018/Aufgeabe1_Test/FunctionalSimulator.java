import java.util.ArrayList;

public class FunctionalSimulator
{
    private class Signal {
        private String Name = "";
        private Boolean Value = false;
        private ArrayList<Nand> Outputs;
        
        public Signal(String NewName){
            Name = NewName;
            Outputs = new ArrayList<>();
        }

        public void setValue(Boolean newValue){
           
            //Debug Befehl:
            //System.out.println(Name + " set to " + newValue);
            Value = newValue;
            for(int i = 0; i < Outputs.size(); i++){ Outputs.get(i).RefreshOutput();}
            if (Name == "i1" || Name == "i2" || Name == "i3") UserOutput();
        
        }
        
        public Boolean getValue(){ return Value; }
        
        public void addOutput(Nand newOut){
            Outputs.add(newOut);
        }
        
        
    }
    
    private class Nand {
        private Signal[] Input;
        private Signal Output;
        
        public Nand (int InputLength){
           Input = new Signal[InputLength];
        }
        
        public void setOutput(Signal newOutput){
            Output = newOutput;
        }
        
        public void setInput(int Index, Signal newInput){
            if (Index < Input.length && Index >= 0) {
                Input[Index] = newInput;
                newInput.addOutput(this);
            }
            
        }
        
        public void RefreshOutput(){
            
            int trueAmount = 0;
            /**AND verknüpfung 
             * Die integer Variable zählt die Anzahl an Signalen mit wahrem Wert in der Array der Inputsignale
             * wenn die VAriable = der Länge der Array heißt das, dass alle Signale wahr sind daher wird das
             * Outputsignal mit einem ! zugewiesen
             */
//            System.out.println("Refreshing Nand " + Output.Name
            for (int i = 0; i < Input.length; i++) if (Input[i].getValue()) trueAmount++;  
            Output.setValue(!(trueAmount == Input.length));
        }
    }
 
    public void UserOutput() {
        System.out.println("s0: " + s0.getValue());
        System.out.println("s1: " + s1.getValue());
    }
    
    // Eingänge (i1-i3) und Ausgänge (s1,s0) der Schaltung
    Signal  i1,i2,i3,s1,s0;
    // Innere Signale, geben das invertierte Signal der Eingänge an
    Signal  ni1,ni2,ni3;
    // Innere Signale, die bei der Berechnung der Summe benötigt werden
    Signal  t1,t2,t3,t4,t5,t6,t7;

    // Nand-Gatter zum Invertieren der Eingänge
    Nand    inv1,inv2,inv3;
    // Nand-Gatter zur Berechnung der Summe
    Nand    n1,n2,n3,n4,n5,n6,n7,n8,n9;

    
    public FunctionalSimulator(){
        // Konstruktor, der die zu simulierende Schaltung aufbaut.
        //Simuliert wird ein einfache Volladdierer.
    

        // Alle Signale anlegen
        // Der Konstruktor bekommt einen Signalnamen als Parameter
        i1=new Signal("i1");
        i2=new Signal("i2");
        i3=new Signal("i3");
        ni1=new Signal("ni1");
        ni2=new Signal("ni2");
        ni3=new Signal("ni3");
        s1=new Signal("s1");
        s0=new Signal("s0");
        t1=new Signal("t1");
        t2=new Signal("t2");
        t3=new Signal("t3");
        t4=new Signal("t4");
        t5=new Signal("t5");
        t6=new Signal("t6");
        t7=new Signal("t7");

        // Alle Gatter anlegen
        // Parameter des Konstruktors ist die Anzahl von Eingängen
        // Die Inverter sind sozusagen entartete Nand-Gatter (1 Eingang)
        inv1=new Nand(1);
        inv2=new Nand(1);
        inv3=new Nand(1);
        n1=new Nand(3);
        n2=new Nand(3);
        n3=new Nand(3);
        n4=new Nand(3);
        n5=new Nand(3);
        n6=new Nand(3);
        n7=new Nand(3);
        n8=new Nand(4);
        n9=new Nand(4);
    
        // Inverter mit Ein- und Ausgängen verbinden.
        // Die Methode setInput() des Gatters bekommt die Nummer des Eingangs
        // und das Signal, mit dem dieser Eingang verbunden werden soll.
        inv1.setInput(0,i1);
        // Die Methode setOutput() bekommt nur ein Signal, welches durch diesen
        // Ausgang bestimmt wird
        inv1.setOutput(ni1);
        inv2.setInput(0,i2);
        inv2.setOutput(ni2);
        inv3.setInput(0,i3);
        inv3.setOutput(ni3);
    
        // Die Nand-Gatter zur Summenberechnung richtig verbinden
        n1.setInput(0,ni1);
        n1.setInput(1,ni2);
        n1.setInput(2,i3);
        n1.setOutput(t1);
        
        n2.setInput(0,ni1);
        n2.setInput(1,i2);
        n2.setInput(2,ni3);
        n2.setOutput(t2);
        
        n3.setInput(0,ni1);
        n3.setInput(1,i2);
        n3.setInput(2,i3);
        n3.setOutput(t3);
        
        n4.setInput(0,i1);
        n4.setInput(1,ni2);
        n4.setInput(2,ni3);
        n4.setOutput(t4);
    
        n5.setInput(0,i1);
        n5.setInput(1,ni2);
        n5.setInput(2,i3);
        n5.setOutput(t5);
    
        n6.setInput(0,i1);
        n6.setInput(1,i2);
        n6.setInput(2,ni3);
        n6.setOutput(t6);
    
        n7.setInput(0,i1);
        n7.setInput(1,i2);
        n7.setInput(2,i3);
        n7.setOutput(t7);

        // n8 und n9 berechnen die eigentlichen Ausgänge
        n8.setInput(0,t1);
        n8.setInput(1,t2);
        n8.setInput(2,t4);
        n8.setInput(3,t7);
        n8.setOutput(s0);
            
        n9.setInput(0,t3);
        n9.setInput(1,t5);
        n9.setInput(2,t6);
        n9.setInput(3,t7);
        n9.setOutput(s1);
    
        // Die Signale s1 und s0 sind mit keinen weiteren Gattern verbunden.
        // Sorgen Sie dafür, dass in diesem Fall eine Wertänderung dieser
        // Signale ausgegeben wird.
        System.out.println("Successfully created FunctionSimulator!");
    }

    
    public void simulate()  {
        /**
         * Diese Methode führt die eigentliche Simulation durch. Dazu werden den
        * Eingangssignalen (i1,i2,i3) einfach nur neue Werte zugeordnet. Diese
        * Wertänderungen propagieren sich dann durch die Schaltung bis zum Ausgang
        * und werden dort ausgegeben.
        */
    
        // Zunächst alle Eingänge auf false setzen (ist zwar schon nach dem)
        // Erzeugen des Gatters so, aber durch ein erneutes Setzen werden
        // die inneren Signale der Schaltung vernünftig berechnet)
        i1.setValue(false);
        i2.setValue(false);
        i3.setValue(false);

        // Eingang i1 auf true: Dadurch sollte als Summe s1=false und s0=true
        // herauskommen. Es ist aber normal, dass Änderungen an s1 und s0 mehrfach
        // ausgegeben werden, bevor das Endergebnis herauskommt.
        System.out.println("==== i1 -> true");
        i1.setValue(true);
        
        // Eingang i1 und i2 auf true: Dadurch sollte als Summe s1=true und
        // s0=false herauskommen.
        System.out.println("==== i2 -> true");
        i2.setValue(true);
        
        // Eingang i1,i2 und i3 auf true: Dadurch sollte als Summe s1=true und
        // s0=true herauskommen.
        System.out.println("==== i3 -> true");
        i3.setValue(true);
        
        // Eingang i1 und i3 auf true: Dadurch sollte als Summe s1=true und
        // s0=false herauskommen.
        System.out.println("==== i2 -> false");
        i2.setValue(false);
        
        // Eingang i3 auf true: Dadurch sollte als Summe s1=false und
        // s0=true herauskommen.
        System.out.println("==== i1 -> false");
        i1.setValue(false);
        
        // Eingang i2 und i3 auf true: Dadurch sollte als Summe s1=true und
        // s0=false herauskommen.
        System.out.println("==== i2 -> true");
        i2.setValue(true);
		
    }
    
    public static void main(String[] args) {
        /**
        * Main Methode dieser Klasse. Sie müssen das im Moment noch nicht
        * verstehen. Diese Methode wird benötigt, wenn Sie den Simulator ohne
        * BlueJ laufen lassen wollen. Wenn Sie diese Klasse in BlueJ nutzen,
        * dann ignorieren Sie diese Methode einfach.
        */
        FunctionalSimulator s=new FunctionalSimulator();
        s.simulate();
    }
}
