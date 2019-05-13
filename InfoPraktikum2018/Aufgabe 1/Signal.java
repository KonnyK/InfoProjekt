
/**
 * Beschreiben Sie hier die Klasse Signal.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Signal extends FunctionalSimulator
{
    private String Name = "";
        private Boolean Value = false;
        
        public Signal(String NewName){
            Name = NewName;
        }

        public void setValue(Boolean newValue){
            /**
             * Wird nur aufgerufen, wenn Eingänge des Volladdieres durch simulate() verändert werden
             * daher wird hier auch immer ein kompletter Durchlauf aller NandGatter gestartet
             */
            Value = newValue;
            PropagateSignals(); //alle Nand Gatter aktualisieren ihre Ausgänge entsprechend ihrer Eingänge
        }
        
        public void setInternValue(Boolean newValue){
            /**
             * Verändert den Wert des Signals. Wird aufgerufen durch die Refresh Funktion eines Nands
             * welche das Output Signal desselben verändert falls die Eingänge das verlangen
             */
            Value = newValue; 
        }
        
        public Boolean getValue(){ return Value; }
}
