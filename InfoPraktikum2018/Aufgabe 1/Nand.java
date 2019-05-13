
/**
 * Beschreiben Sie hier die Klasse Nand.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Nand extends FunctionalSimulator
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
            if (Index < Input.length && Index >= 0) Input[Index] = newInput;
            
        }
        
        public void RefreshOutput(){
            int trueAmount = 0;
            /**AND verknüpfung 
             * Die integer Variable zählt die Anzahl an Signalen mit wahrem Wert in der Array der Inputsignale
             * wenn die VAriable = der Länge der Array heißt das, dass alle Signale wahr sind daher wird das
             * Outputsignal mit einem ! zugewiesen
             */
            for (int i = 0; i < Input.length; i++) if (Input[i].getValue()) trueAmount++;  
            Output.setInternValue(!(trueAmount == Input.length));
        }
}
