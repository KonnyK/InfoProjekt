
/**
 * Write a description of class Punkt here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.lang.Math;
public class Punkt
{
    // instance variables - replace the example below with your own
    private int x=0;
    private int y=0;
    
    public Punkt(){}
    public Punkt(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getX(){ return x; }
    public int getY(){ return y; }
    public void setX(int value){ x=value; }
    public void setY(int value){ y=value; }
    public void addX(int value){ x+=value; }
    public void addY(int value){ y+=value; }
    public String Ausgabe(){ return ("Punkt: " + x + "|" + y); }
    public void bewegeUm(int dx, int dy){ x += dx; y += dy; }
    public boolean isInRect(Rechteck R)
    {
        int x1 = R.getPos().getX();
        int y1 = R.getPos().getY();
        int a = R.getBreite();
        int b = R.getHoehe();
        return ( x >= x1 && x <= (x1+a) && y >= y1 && y <= (y1+b));
    }
    public double gibAbstand(Punkt other)
    {
        return Math.sqrt(Math.pow(x-other.getX() ,2) + Math.pow(y-other.getY(), 2));
    }
}
