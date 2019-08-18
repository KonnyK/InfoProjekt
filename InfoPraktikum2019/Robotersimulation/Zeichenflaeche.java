
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
    public boolean ZeichneLinie = false;
    public ArrayList<Figur> ZuZeichnen = new ArrayList<Figur>();
    public Rechteck Hintergrund;
    private ArrayList<Punkt> Linie = new ArrayList<Punkt>();
    
    public void Clear()
     {
         ZuZeichnen.clear();
         Linie.clear();
     }
    
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
                g.fillArc(K.getPos().getX(), K.getPos().getY(), K.getRadius() * 2, K.getRadius() * 2, 0, 360);
                if (ZeichneLinie) Linie.add(new Punkt(K.getPos().getX() + K.getRadius() , K.getPos().getY() + K.getRadius() ));
            }
        }
        if (Linie.size() > 1 && ZeichneLinie) for (int i = 1; i < Linie.size() - 1; i++) g.drawLine(Linie.get(i-1).getX(), Linie.get(i-1).getY(), Linie.get(i).getX(), Linie.get(i).getY());
        g.setColor(Color.black);
    }
    
}
