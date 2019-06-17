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
    Leinwand leinwand;
    
    public Spielfeld()
    {
        leinwand = new Leinwand(breite, hoehe, Color.pink);
    }
    
    private int RNum(int von, int bis){ return (RGen.nextInt(bis-von) + von); }
    
    private Color RCol(){ return new Color(RGen.nextFloat(), RGen.nextFloat(), RGen.nextFloat()); }
        
    public void main()
    {
        Roboter Robbi = new Roboter();
        while (true) 
        {
            System.out.println("-----------------------------------");
            System.out.println("Willkommen bei der Roboterhotline Robo drive 'n talk.");
            System.out.println("Für eine Navigation entlang der Points of Interest wählen sie die 1");
            System.out.println("Wollen sie die Hindernisse umfahren, wählen sie die 2.");
            System.out.println("Wenn sie eine Frage haben, wählen sie die 3.");
            System.out.println("Wenn sie kein Bock mehr haben drücken sie die 4 und verpissen sie sich!!!!");
            int Nr = getAnzahlEingabe("");
            switch(Nr)
            {
                 //case 1: HindernisseAbfahren(); break;
                 //case 2: HindernisseUmfahren(); break;
                 case 3: Robbi.Spracherkennung(); break;
                 case 4: return;
            }
        }      
    }
    
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
    
    public void poiSortieren(ArrayList<Punkt> POI)
    ///vergleicht für jeden Punkt Ob der Abstand zu Punkte[0] größer ist als der des Vorgängers. Wenn nicht werden die beiden getauscht.
    {
        POI.sort(new Comparator<Punkt>()
        {
            @Override 
            public int compare(Punkt P1, Punkt P2)
            {
                long Abstand1 = Math.round(100*P1.gibAbstand(POI.get(0)));
                long Abstand2 = Math.round(100*P2.gibAbstand(POI.get(0)));
                return Math.toIntExact(Abstand1-Abstand2);
            }
        });
        System.out.println("Sortiere Punkte...");
        double Gesamtweg = 0;
        for (int i = 1; i < POI.size(); i++)
        {
            double Abstand = POI.get(i-1).gibAbstand(POI.get(i)); 
            Gesamtweg += Abstand;
            String P1 = "Punkt" + (i-1) + "(" + POI.get(i-1).getX() + "|" + POI.get(i-1).getY() + ")";
            String P2 = "Punkt" + i + "(" + POI.get(i-1).getX() + "|" + POI.get(i-1).getY() + ")";
            System.out.println(i + ".Teilstrecke: " + P1 + " --> " + P2 + " : " + (double)Math.round(100*Abstand)/100 + "px");
        }
        System.out.println("Gesamte Strecke: " + (double)Math.round(100*Gesamtweg)/100 + "px");
        
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
    
    private void zeichnen(ArrayList<Rechteck> Hindis)
    {
        ArrayList<Figur> Hindos = new ArrayList<Figur>();
        for (Rechteck R : Hindis) Hindos.add(new Rechteck(R.getPos(), R.getBreite(), R.getHoehe(), R.getName(), R.getFarbe()));
        leinwand.zeichne(Hindos);
    }
    
    public void hindernisseErzeugen()
    ///fragt ab wieviele Hindernisse erzeugt werden sollen und testet für jedes ob es im Spielfeld liegt
    {
        Hindernisse.clear();
        int Anzahl = getAnzahlEingabe("Wieviele Hindernisse soll es geben?");
        for (int i = 0; i < Anzahl; i++)
        {
            boolean Finished = false;
            while (!Finished)
            {
                Punkt P1 = new Punkt(RNum(0, breite), RNum(0,hoehe));
                Punkt P2 = new Punkt(RNum(0, breite), RNum(0,hoehe));
                Punkt Pos = new Punkt(Math.min(P1.getX(), P2.getX()), Math.min(P1.getY(), P2.getY()));
                Punkt Maße = new Punkt( Math.max(P1.getX(),P2.getX()) - Pos.getX(), Math.max(P1.getY(),P2.getY()) - Pos.getY());
                Rechteck Neu = new Rechteck(Pos, Maße.getX(), Maße.getY(), "Rechteck " + i, RCol());
                boolean Overlap = false;
                for (Rechteck R : Hindernisse) if (Neu.ueberlappt(R)) Overlap = true;
                if (Maße.getX() != 0 && Maße.getY() != 0)
                {
                    float SV = Maße.getX()/Maße.getY(); //Seitenverhältnis
                    int A = Maße.getX() * Maße.getY(); //Fläche
                    if (!Overlap && SV <= 2 && SV >= 0.5f && A <= 10000 && A >= 800)
                    {
                        System.out.println(i);
                        Hindernisse.add(Neu);
                        Finished = true;
                    }
                }
            }            
        }
        int Area = 0;
        for (int i = 0; i< Hindernisse.size(); i++) 
        {
            Rechteck R = Hindernisse.get(i);
            int SubArea = R.getBreite() * R.getHoehe();
            System.out.println("Rechteck" + i + ": " + (double) SubArea/10000 + "% Fläche");
            Area += SubArea;
        }
        System.out.println("Insgesamt " + (double) Area/10000 + "% Flächennutzung");
        zeichnen(Hindernisse);
    }
    
    public void hindernisse_umfahren()
    {
        hindernisseErzeugen();
        Roboter Rob = new Roboter();
        leinwand.zeichne(Rob);
        int Überlauf = 0;
        while (Überlauf<2000 && (Rob.getPos().getX() < 1000-2*Rob.getRadius() || Rob.getPos().getY() < 1000-2*Rob.getRadius()))
        {
            Überlauf++;
            System.out.println(Überlauf);
            Punkt nextPos = new Punkt(Rob.getPos().getX() + 1, Rob.getPos().getY() + 1);
            Rob.setPos(nextPos);
            int Korrekturen = 0;
            for (Rechteck Rect:Hindernisse)
            {
                if (Rob.ueberlappt(Rect))
                {
                    int LastKorrekturen = Korrekturen;
                    if (Rob.getPos().getX() <= Rect.getPos().getX())
                    {
                        Rob.setPos(new Punkt(Rob.getPos().getX() - 1, Rob.getPos().getY()));
                        Korrekturen++;
                    }
                    if (Rob.getPos().getY() <= Rect.getPos().getY())
                    {
                        Rob.setPos(new Punkt(Rob.getPos().getX(), Rob.getPos().getY() - 1));
                        Korrekturen++;
                    }
                    if (LastKorrekturen-Korrekturen > 1) 
                    {
                        Rob.setPos(new Punkt(Rob.getPos().getX(), Rob.getPos().getY() -1));
                        Korrekturen--;
                    }
                }
            }
            if (Rob.getPos().getX() > 1000-2*Rob.getRadius())
            {
                Rob.setPos(new Punkt(Rob.getPos().getX() - 1, Rob.getPos().getY()));
                Korrekturen++;
            }
            if (Rob.getPos().getY() > 1000-2*Rob.getRadius())
            {
                Rob.setPos(new Punkt(Rob.getPos().getX(), Rob.getPos().getY() - 1));
                Korrekturen++;
            }
            if (Korrekturen > 1) return;
            leinwand.Erneuern();
            //leinwand.warte(100);
        }
        
    }
}
