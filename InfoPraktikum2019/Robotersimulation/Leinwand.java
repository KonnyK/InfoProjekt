
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
    Color hintergrundfrabe = Color.BLACK;
    Zeichenflaeche Canvas = new Zeichenflaeche();
    
    public Leinwand(int breite, int hoehe, Color hintergrundfarbe)
    {
        this.breite = breite;
        this.hoehe = hoehe;
        hintergrundfarbe = hintergrundfarbe;
        fenster.setSize(breite, hoehe);
        fenster.setBackground(hintergrundfarbe);
        fenster.enable();
    };
    
    public void Zeichnen(ArrayList<Rechteck> Hindernisse)
    {
        Canvas.ZuZeichnen = Hindernisse;
        fenster.setVisible(true);
    }
}
