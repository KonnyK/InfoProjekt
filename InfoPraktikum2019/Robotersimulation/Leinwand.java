
/**
 * Write a description of class Leinwand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Leinwand
{
    private static Leinwand Lsingleton = new Leinwand(1000, 1000, Color.pink);
    public static Leinwand gibLeinwand() { return Lsingleton; }
    private int breite;
    private int hoehe;    
    JFrame fenster = new JFrame();
    Color hintergrundfarbe = Color.BLACK;
    Zeichenflaeche Canvas = new Zeichenflaeche();
    
    private Leinwand(int breite, int hoehe, Color hintergrundfarbe)
    {
        this.breite = breite;
        this.hoehe = hoehe;
        this.hintergrundfarbe = hintergrundfarbe;
        fenster.setContentPane(Canvas);
        fenster.setTitle("Robotersimulation");
        fenster.setPreferredSize(new Dimension(breite+16, hoehe+39));
        fenster.pack();
        Canvas.Hintergrund = new Rechteck(new Punkt(), breite, hoehe, "", hintergrundfarbe);    
    };
    
    public void zeichne(ArrayList<Figur> hindernisse)
    {
        fenster.setVisible(true);
        Canvas.Clear();
        for (Figur F : hindernisse)
        {
            Canvas.ZuZeichnen.add(F);
        }
    }
    
    public void zeichne(Figur F)
    {
        fenster.setVisible(true);
        Canvas.ZuZeichnen.add(F); 
    }
    
    public void ZeichneLinie(boolean value)
    {
        Canvas.ZeichneLinie = value;
    }
    
    public void LeereZeichenfläche(){ Canvas.Clear(); }
    
    public void Erneuern()
    {
        Canvas.revalidate();
        Canvas.repaint();
    }
    
    public void warte(int millisekunden)
    {
        try
        {  
            Thread.sleep(millisekunden);
        }
        catch (Exception E)
        {
            
        }
    }
    
}
