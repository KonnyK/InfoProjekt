/**
 * Write a description of class Spielfeld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.awt.Color;

public class Spielfeld
{
    final int breite = 1000;
    final int hoehe = 1000;
    Punkt[] Punkte = new Punkt[0];
    Random RGen = new Random();
    ArrayList<Rechteck> Hindernisse = new ArrayList<Rechteck>();
    
    public Spielfeld(){}
    
    private int RNum(int von, int bis){ return (RGen.nextInt(bis-von) + von); }
    
    private Color RCol(){ return new Color(RGen.nextFloat(), RGen.nextFloat(), RGen.nextFloat()); }
        
    private int getAnzahlEingabe(String Message)
    {
        Scanner Scan = new Scanner(System.in);
        System.out.println("-----------------------------------");
        System.out.println(Message);
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
        if (!EingabeKorrekt) return getAnzahlEingabe(Message);
        else return Anzahl;
    }
    
    public Punkt[] PunktEingabe()
    {
        Scanner Scan = new Scanner(System.in);
        int Anzahl = getAnzahlEingabe("Wieviele Punkte sollen abgefahren werden?");
        boolean PunktErkannt = false;
        
        System.out.println("Erstelle " + Anzahl + " Punkte...");
        Punkte = new Punkt[Anzahl+1];
        Punkte[0] = new Punkt();
        for(int i = 1; i < Punkte.length; i++)
        {
            System.out.println("Geben die Koordinaten des " + i + "ten Punktes ein!");
            System.out.println("Format:x,y");
            PunktErkannt = false;
            while (!PunktErkannt)
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
                        PunktErkannt = true;
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
    
    public void hindernisseErzeugen()
    {
        for (int i = 0; i < getAnzahlEingabe("Wieviele Hindernisse soll es geben?"); i++)
        {
            boolean RectInSpielfeld = false;
            Rechteck Spielfeld = new Rechteck(new Punkt(), breite, hoehe,"" ,Color.BLACK);
            Punkt P1 = new Punkt();
            Punkt P2 = new Punkt();
            while (!RectInSpielfeld)
            {
                P1 = new Punkt(RNum(0, breite), RNum(0,hoehe));
                P2 = new Punkt(RNum(0, breite), RNum(0,hoehe));
                RectInSpielfeld = (P1.isInRect(Spielfeld) && P2.isInRect(Spielfeld));
            }
            Punkt Pos = new Punkt(Math.min(P1.getX(), P2.getX()), Math.min(P1.getY(), P2.getY()));
            Punkt Maße = new Punkt(Math.max(P1.getX(), P2.getX()), Math.max(P1.getY(), P2.getY()));
            Hindernisse.add(new Rechteck(Pos, Maße.getX(), Maße.getY(), "Rechteck " + i, RCol()));
            
        }
    }
}
