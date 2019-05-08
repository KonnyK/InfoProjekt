
/**
 * Write a description of class Signal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Signal{

        private String Name = "";
        private Boolean Value = false;
        private static HashMap<Signal, ArrayList<Nand>> connections = new HashMap();
        
        
        public Signal(String NewName){
            Name = NewName;
            connections.put(this, new ArrayList<Nand>());
        }

        public void setValue(Boolean newValue){
            Value = newValue;
            
            for(int i = 0; i < connections.get(this).size(); i++){ connections.get(this).get(i).RefreshOutput();}
             
        
        }
        
        public Boolean getValue(){ return Value; }
        
        public void addOutput(Nand newOut){
            connections.get(this).add(newOut);
        }
        
        public void print(){
            if (Name == "s0" || Name == "s1")System.out.println(Name + ": " + Value);
            }
    }

