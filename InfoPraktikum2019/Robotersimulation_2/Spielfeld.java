import java.util.*;
/**
 * Write a description of class Spielfeld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Spielfeld
{
    final int breite = 1000;
    final int hoehe = 1000;
    Punkt[] Punkte = new Punkt[0];
    
    public Spielfeld(){}
    
    public Punkt[] PunktEingabe()
    {
        Scanner Scan = new Scanner(System.in);
        System.out.println("-----------------------------------");
        System.out.println("Wieviele Punkte sollen abgefahren werden?");
        int Anzahl = 0;
        boolean x = false;
        while (true)
        {
            try
            {
                Anzahl = Scan.nextInt();
                x = (Anzahl > 0);
                break;
            }
            catch (Exception E)
            { 
                System.out.println("Geben Sie bitte eine passende Zahl ein?");
                break;
            }                    
        }
        if (!x) return PunktEingabe();
        System.out.println("Erstelle " + Anzahl + " Punkte...");
        Punkte = new Punkt[Anzahl+1];
        Punkte[0] = new Punkt();
        
        for(int i = 1; i <= Punkte.length; i++)
        {
            System.out.println("Geben die Koordinaten des " + (i) + "ten Punktes ein!");
            System.out.println("Format:x,y");
            boolean Erkannt = false;
            while (!Erkannt)
            {
                String Eingabe = Scan.next();
                String[] Koordinaten = Eingabe.split(",",3);
                
                try
                {
                    Punkte[i] = new Punkt();
                    int Zahl = Integer.valueOf(Koordinaten[0]);
                    Punkte[i].setX(Zahl);
                    Zahl = Integer.valueOf(Koordinaten[1]);
                    Punkte[i].setY(Zahl); 
                    Erkannt = true;
                    
                }
                catch (Exception E)
                { 
                    System.out.println("Fehlerhafte Eingabe!");
                }           
            }
        }
        return Punkte;
    }
}
