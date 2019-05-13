
/**
 * Write a description of class Nand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Nand
{
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
            Output.print();
        }
    }

