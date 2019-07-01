
/**
 * Write a description of class Kreis here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.Color;
public class Kreis extends Figur
{
    private int radius = 0;
    
    public int getRadius(){return radius;}
    public void setRadius(int value){radius = value;}
    
    @Override
    public int minX(){return getPos().getX();}
    @Override
    public int maxX(){return getPos().getX() + radius;}
    @Override
    public int minY(){return getPos().getY();}
    @Override
    public int maxY(){return getPos().getY() + radius;}
    
    public Kreis(){}
    public Kreis(Punkt Pos, int Radius, Color Farbe)
    {
        this.setPos(Pos);
        this.setFarbe(Farbe);
        this.setRadius(Radius);
    }
    public Kreis(Kreis K)
    {
        this.setFarbe(K.getFarbe());
        this.setPos(K.getPos());
        this.setRadius(K.getRadius());
    }
    
    @Override
    public boolean ueberlappt(Rechteck R)
    {
        Rechteck R_Kreis = new Rechteck(getPos(), 2*radius, 2*radius, "", Color.white);
        Punkt M1 = new Punkt(getPos().getX() + radius, getPos().getY() + radius);
        Punkt M2 = new Punkt(R.getPos().getX() + R.getBreite()/2, R.getPos().getY() + R.getHoehe()/2);
        
        Punkt P1 = new Punkt(R.getPos().getX(), R.getPos().getY());
        Punkt P2 = new Punkt(R.getPos().getX() + R.getBreite(), R.getPos().getY());
        Punkt P3 = new Punkt(R.getPos().getX(), R.getPos().getY() + R.getHoehe());
        Punkt P4 = new Punkt(R.getPos().getX() + R.getBreite(), R.getPos().getY() + R.getHoehe());
        boolean X = (R.getPos().getX() <= M1.getX() && M1.getX() <= R.getPos().getX() + R.getBreite());
        boolean Y = (R.getPos().getY() <= M1.getY() && M1.getY() <= R.getPos().getY() + R.getHoehe());
        boolean EckeImKreis = (P1.gibAbstand(M1) <= radius)||(P2.gibAbstand(M1) <= radius)||(P3.gibAbstand(M1) <= radius)||(P4.gibAbstand(M1) <= radius);
        
        if (!R_Kreis.ueberlappt(R)) return false;
        else if (X || Y)
        {
            return true;            
        }
        else return EckeImKreis;
        
    }
}
