import java.awt.Color;

/**
 * Write a description of class Rechteck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rechteck
{
    Punkt Pos = new Punkt();
    int breite = 0;
    int hoehe = 0;
    String name = "";
    Color farbe = Color.black;
    
    public Rechteck(){}
    public Rechteck(Punkt pos, int breite, int hoehe, String name, Color farbe)
    {
        setPosition(pos);
        setBreite(breite);
        setHoehe(hoehe);
        setName(name);
        setFarbe(farbe);
    }
    
    public void setPosition(Punkt pos)
    {
        Pos.setX(pos.getX());
        Pos.setY(pos.getY());
    }
    public void setBreite(int breite){ this.breite = Math.abs(breite); }
    public void setHoehe(int hoehe){ this.hoehe = Math.abs(hoehe); }
    public void setName(String name){ this.name = name; }
    public void setFarbe(Color farbe){ this.farbe = farbe; }
    
    public Punkt getPosition(){ return Pos; }
    public int getBreite(){ return breite; }
    public int getHoehe(){ return hoehe; }
    public String getName(){ return name; }
    public Color setFarbe(){ return farbe; }
    
    public boolean ueberlappt(Rechteck R)
    {
        if (breite * hoehe > R.getBreite() * R.getHoehe()) return R.ueberlappt(this);
        Punkt P1 = new Punkt(Pos.getX() + breite, Pos.getY());
        Punkt P2 = new Punkt(Pos.getX() , Pos.getY() + hoehe);
        Punkt P3 = new Punkt(Pos.getX() + breite, Pos.getY() + hoehe);
        return (Pos.isInRect(R) || P1.isInRect(R) || P2.isInRect(R) || P3.isInRect(R));
    }
    public void bewegeUm(int dx, int dy){ Pos.bewegeUm(dx, dy); }
    public void bewegeUm(Punkt Delta){ Pos.bewegeUm(Delta.getX(), Delta.getY()); }
    public void ausgabeAttribute()
    {
        System.out.println("Rechteck-"+name+"-:");
        System.out.println("Pos:"+Pos.getX()+"|"+Pos.getY());
        System.out.println("Maße:"+breite+"x"+hoehe);
        System.out.println("Farbe(RGB):"+farbe.getRed()+","+farbe.getGreen()+","+farbe.getBlue());
    }    
}
