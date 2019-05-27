
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
    
    public ArrayList<Rechteck> ZuZeichnen = new ArrayList<Rechteck>();
    public Rechteck Hintergrund;
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Hintergrund.getFarbe());
        g.fillRect(Hintergrund.getPos().getX(), Hintergrund.getPos().getY(), Hintergrund.getBreite(), Hintergrund.getHoehe());
        for (Rechteck R : ZuZeichnen)
        {
            g.setColor(R.getFarbe());
            g.fillRect(R.getPos().getX(), R.getPos().getY(), R.getBreite(), R.getHoehe());
        }
        g.setColor(Color.black);
        for (Rechteck R : ZuZeichnen)
        {
            g.drawString(Integer.toString(ZuZeichnen.indexOf(R)), R.getPos().getX(), R.getPos().getY());
        }
    }
    
}
