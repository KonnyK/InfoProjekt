
/**
 * Write a description of class Figur here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
public abstract class Figur
{
    protected Punkt Pos = new Punkt();
    protected Color farbe = Color.black;   
    
    public Figur(){}
    
    public void setPos(Punkt pos)
    {
        Pos.setX(pos.getX());
        Pos.setY(pos.getY());
    }
    public void setFarbe(Color farbe){ this.farbe = farbe; }
    
    public Punkt getPos(){ return Pos; }
    public Color getFarbe(){ return farbe; }
    
    public abstract boolean ueberlappt(Rechteck R);
    public void bewegeUm(int dx, int dy){ Pos.bewegeUm(dx, dy); }
    public void bewegeUm(Punkt Delta){ Pos.bewegeUm(Delta.getX(), Delta.getY()); }
    
    public abstract int minX();
    public abstract int maxX();
    public abstract int minY();
    public abstract int maxY();
    
}
