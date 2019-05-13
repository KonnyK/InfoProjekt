
/**
 * Beschreiben Sie hier die Klasse Mamaklasse.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.ArrayList;
public class Mamaklasse
{
    public ArrayList<Kinderklasse> Testliste;
    
    public Mamaklasse(int kids){
        super();
        Testliste = new ArrayList<Kinderklasse>();
        Kinderklasse.setMum(this);
        Kinderklasse[] kinder = new Kinderklasse[kids];
        for (int i = 0; i < kids; i++) Add(kinder[i]);
    }
    
    public void Add(Kinderklasse k){
        
            Testliste.add(k);
        
    }
}
