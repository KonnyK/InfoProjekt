
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
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (Rechteck R : ZuZeichnen)
        {
            g.setColor(R.getFarbe());
            g.drawRect(R.getPos().getX(), R.getPos().getY(), R.getBreite(), R.getHoehe());
        }
    }
    
}
