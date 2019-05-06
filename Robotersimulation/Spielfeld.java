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
        boolean EingabeKorrekt = false;
        while (true)
        {
            try
            {
                Anzahl = Scan.nextInt();
                if (Anzahl < 0) System.out.println("Bitte geben Sie eine Zahl größer null ein.");
                EingabeKorrekt = (Anzahl > 0);
                break;
            }
            catch (Exception E)
            { 
                System.out.println("Geben Sie bitte eine passende Zahl ein?");
                break;
            }                    
        }
        if (!EingabeKorrekt) return PunktEingabe();
        System.out.println("Erstelle " + Anzahl + " Punkte...");
        Punkte = new Punkt[Anzahl+1];
        Punkte[0] = new Punkt();
        for(int i = 1; i < Punkte.length; i++)
        {
            System.out.println("Geben die Koordinaten des " + i + "ten Punktes ein!");
            System.out.println("Format:x,y");
            EingabeKorrekt = false;
            while (!EingabeKorrekt)
            {
                String Eingabe = Scan.next();
                String[] Koordinaten = Eingabe.split(",",3);
                
                try
                {
                    int x = Integer.valueOf(Koordinaten[0]);
                    int y = Integer.valueOf(Koordinaten[1]);
                    if (x >= 0 && x <= breite && y >= 0 && y <= hoehe)
                    {
                        Punkte[i] = new Punkt();
                        Punkte[i].setX(x);
                        Punkte[i].setY(y); 
                        EingabeKorrekt = true;
                    } else System.out.println("Punkt liegt nicht im Spielfeld(X:0..."+breite+" Y:=..."+hoehe);
                }
                catch (Exception E)
                { 
                    System.out.println("Fehlerhafte Eingabe.");
                }                    
            }
        }
        return Punkte;
    }
    
    public void poiSortieren()
    {
        boolean Fertig = false;
        while (!Fertig)
        {
            Fertig = true;
            for (int i = 1; i < Punkte.length; i++)
            { 
                if (Punkte[i].gibAbstand(Punkte[0]) < Punkte[i-1].gibAbstand(Punkte[0]))
                {
                    Punkt P = new Punkt(Punkte[i].getX(), Punkte[i].getY());
                    Punkte[i] = Punkte[i-1];
                    Punkte[i-1] = P;
                    Fertig = false;
                }
            }   
        }
    }
}
