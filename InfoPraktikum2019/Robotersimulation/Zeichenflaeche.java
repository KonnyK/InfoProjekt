
/**
 * Write a description of class Zeichenflaeche here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Zeichenflaeche extends JPanel
{
    
    public ArrayList<Figur> ZuZeichnen = new ArrayList<Figur>();
    public Rechteck Hintergrund;
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Hintergrund.getFarbe());
        g.fillRect(Hintergrund.getPos().getX(), Hintergrund.getPos().getY(), Hintergrund.getBreite(), Hintergrund.getHoehe());
        for (Figur F : ZuZeichnen)
        {
            g.setColor(F.getFarbe());
            if (F.getClass() == new Rechteck().getClass()) 
            {
                Rechteck R = (Rechteck) F;
                g.fillRect(R.getPos().getX(), R.getPos().getY(), R.getBreite(), R.getHoehe());
            }
            if (F.getClass() == new Kreis().getClass() || F.getClass() == new Roboter().getClass()) 
            {
                Kreis K = (Kreis) F;
                g.fillArc(K.getPos().getX()+K.getRadius(), K.getPos().getY()+K.getRadius(), K.getRadius(), K.getRadius(), 0, 360);
            }
        }
        g.setColor(Color.black);
        for (Figur R : ZuZeichnen)
        {
            if (R.getClass() == new Rechteck().getClass()) g.drawString(Integer.toString(ZuZeichnen.indexOf(R)), R.getPos().getX(), R.getPos().getY());
        }
    }
    
}
