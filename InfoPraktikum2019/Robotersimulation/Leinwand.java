
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

       
    };
    
    public void zeichne(ArrayList<Rechteck> hindernisse)
    {
        fenster.setVisible(true);
        Canvas.ZuZeichnen = hindernisse;
        Canvas.Hintergrund = new Rechteck(new Punkt(), breite, hoehe, "", hintergrundfarbe);
    }
    
    private void warten(int millisekunden)
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
