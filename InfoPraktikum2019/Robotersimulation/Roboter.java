
/**
 * Write a description of class Roboter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.lang.*;

public class Roboter
{
    private enum Stichwort
    {
        Name("Mein Name geht dich gar nichts an!"),
        Hersteller("Gott hat die Welt schaffen wollte war ich schon fertig."),
        Alter("Frag nicht, ich bin zu alt für den Scheiß."),
        Geschlecht("Hast du grad nen Roboter nach seinem Geschlecht gefragt?! Divers natürlich...");
        
        public String Output;
        Stichwort(String newOutput){ this.Output = newOutput; }
    }
    
    public void Spracherkennung()
    {
        System.out.println("Spracherkennung gestartet");
        Scanner Scan = new Scanner(System.in);
        boolean StopRequested = false;
        while (true)
        {
            String[] Input = Scan.next().split(" ");
            for (String S : Input)
            {
                switch (S.toUpperCase())
                {
                    case "NAME": 
                    {
                        System.out.println("Mein Name geht dich gar nichts an!");
                        break;
                    }
                    case "HERSTELLER": 
                    {
                        System.out.println("Gott hat die Welt schaffen wollte war ich schon fertig.");
                        break;
                    }
                    case "GESCHLECHT": 
                    {
                        System.out.println("Hast du grad nen Roboter nach seinem Geschlecht gefragt?! Divers natürlich...");
                        break;
                    }
                    case "ALTER" :
                    {
                        System.out.println("Frag nicht, ich bin zu alt für den Scheiß.");
                        break;
                    }
                    case "STOP":
                    {
                        StopRequested = true;
                    }
                }
            }
            if (StopRequested) { return;}
        }
    }
}
