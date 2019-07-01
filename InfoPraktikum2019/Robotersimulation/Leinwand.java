
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
    private int breite;
    private int hoehe;    
    JFrame fenster = new JFrame();
    Color hintergrundfarbe = Color.BLACK;
    Zeichenflaeche Canvas = new Zeichenflaeche();
    
    public Leinwand(int breite, int hoehe, Color hintergrundfarbe)
    {
        this.breite = breite;
        this.hoehe = hoehe;
        this.hintergrundfarbe = hintergrundfarbe;
        fenster.setContentPane(Canvas);
        fenster.setSize(breite, hoehe);
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
