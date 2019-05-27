
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
    
    public Leinwand(int breite, int hoehe, ArrayList<Rechteck> Hindernisse)
    {
        this.breite = breite;
        this.hoehe = hoehe;
        Color hintergrundfarbe = Color.blue;
        this.hintergrundfarbe = hintergrundfarbe;
        
        Canvas.ZuZeichnen = Hindernisse;
        
        fenster.setSize(breite, hoehe);
        fenster.setBackground(hintergrundfarbe);
        fenster.add(Canvas);
        fenster.setVisible(true);
    };
    
}
