
/**
 * Beschreiben Sie hier die Klasse familie.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class familie
{
    private Mamaklasse M;
    
    public familie(){
       M = new Mamaklasse(5);  
    }
    
    public void useMama(){
       
       System.out.print(M.Testliste.size());
    }
}
