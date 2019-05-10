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
    ArrayList<Punkt> Punkte = new ArrayList<Punkt>();
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
            String Eingabe = Scan.next();
            try
            {
                Anzahl = Integer.valueOf(Eingabe);
                if (Anzahl < 0) System.out.println("Bitte geben Sie eine Zahl größer null ein.");
                EingabeKorrekt = (Anzahl > 0);
                break;
            }
            catch (Exception E)
            { 
                if (Eingabe.contains("stop")) 
                {
                    Scan.close();
                    EingabeKorrekt = true;
                    Anzahl = 0;
                }
                else 
                {
                    System.out.println("Geben Sie bitte eine passende Zahl ein?");
                }
                break;
            }                    
        }
        if (!EingabeKorrekt) return getAnzahlEingabe(Message);
        else return Anzahl;
    }

    public ArrayList<Punkt> PunktEingabe()
    {
        Scanner Scan = new Scanner(System.in);
        int Anzahl = getAnzahlEingabe("Wieviele Punkte sollen abgefahren werden?");
        boolean PunktErkannt = false;
        Punkte.clear();
        
        if (Anzahl == 0) return Punkte;
        
        System.out.println("Erstelle " + Anzahl + " Punkte...");
        Punkte.add(new Punkt());
        
        for(int i = 1; i <= Anzahl; i++)
        {
            System.out.println("Geben Sie die Koordinaten des " + i + "ten Punktes ein!");
            System.out.println("Format:x,y");
            PunktErkannt = false;
            while (!PunktErkannt)
            {
                String Eingabe = Scan.next();
                if (Eingabe.contains("stop")) return Punkte;
                
                String[] Koordinaten = Eingabe.split(",",3);
                try
                {
                    int x = Integer.valueOf(Koordinaten[0]);
                    int y = Integer.valueOf(Koordinaten[1]);
                    if (x >= 0 && x <= breite && y >= 0 && y <= hoehe)
                    {
                        Punkte.add(new Punkt(x,y));
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
    ///vergleicht für jeden Punkt Ob der Abstand zu Punkte[0] größer ist als der des Vorgängers. Wenn nicht werden die beiden getauscht.
    {
        Punkte.sort(new Comparator<Punkt>()
        {
            @Override 
            public int compare(Punkt P1, Punkt P2)
            {
                long Abstand1 = Math.round(P1.gibAbstand(Punkte.get(0)));
                long Abstand2 = Math.round(P2.gibAbstand(Punkte.get(0)));
                return Math.toIntExact(Abstand1-Abstand2);
            }
        });
            
        
        /*
        boolean InOrdnung = false;
        while (!InOrdnung)
        {
            InOrdnung = true;
            for (int i = 1; i < Punkte.size(); i++)
            { 
                if (Punkte.get(i).gibAbstand(Punkte.get(0)) < Punkte.get(i-1).gibAbstand(Punkte.get(0)))
                {
                    Punkt Zwischenablage = new Punkt(Punkte.get(i).getX(), Punkte.get(i).getY());
                    Punkte.get(i).setX(Punkte.get(i-1).getX());
                    Punkte.get(i).setY(Punkte.get(i-1).getY());
                    Punkte.get(i-1).setX(Zwischenablage.getX());
                    Punkte.get(i-1).setY(Zwischenablage.getY());
                    InOrdnung = false;
                }
            }  
        } */
    }
    
    public void hindernisseErzeugen()
    ///fragt ab wieviele Hindernisse erzeugt werden sollen und testet für jedes ob es im Spielfeld liegt
    {
        for (int i = 0; i < getAnzahlEingabe("Wieviele Hindernisse soll es geben?"); i++)
        {
            boolean Overlap = true;
            Rechteck Spielfeld = new Rechteck(new Punkt(), breite, hoehe,"" ,Color.BLACK);
            Punkt P1 = new Punkt();
            Punkt P2 = new Punkt();
            
            while (Overlap)
            {
                Overlap = false;
                P1 = new Punkt(RNum(0, breite), RNum(0,hoehe));
                P2 = new Punkt(RNum(0, breite), RNum(0,hoehe));
                for (Rechteck R : Hindernisse) if (P1.isInRect(R) || P2.isInRect(R)) Overlap = true;
 
            }
            Punkt Pos = new Punkt(Math.min(P1.getX(), P2.getX()), Math.min(P1.getY(), P2.getY()));
            Punkt Maße = new Punkt(Math.max(P1.getX(), P2.getX()), Math.max(P1.getY(), P2.getY()));
            Hindernisse.add(new Rechteck(Pos, Maße.getX(), Maße.getY(), "Rechteck " + i, RCol()));
            
        }
    }
}
