import java.awt.Color;

/**
 * Write a description of class Rechteck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rechteck
{
    Punkt position = new Punkt();
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
        position.setX(pos.getX());
        position.setY(pos.getY());
    }
    public void setBreite(int breite){ this.breite = Math.abs(breite); }
    public void setHoehe(int hoehe){ this.hoehe = Math.abs(hoehe); }
    public void setName(String name){ this.name = name; }
    public void setFarbe(Color farbe){ this.farbe = farbe; }
    
    public Punkt getPosition(){ return position; }
    public int getBreite(){ return breite; }
    public int getHoehe(){ return hoehe; }
    public String getName(){ return name; }
    public Color setFarbe(){ return farbe; }
    
    public void bewegeUm(int dx, int dy){ position.bewegeUm(dx, dy); }
    public void bewegeUm(Punkt Delta){ position.bewegeUm(Delta.getX(), Delta.getY()); }
    public void ausgabeAttribute()
    {
        System.out.println("Rechteck-"+name+"-:");
        System.out.println("Pos:"+position.getX()+"|"+position.getY());
        System.out.println("Maße:"+breite+"x"+hoehe);
        System.out.println("Farbe(RGB):"+farbe.getRed()+","+farbe.getGreen()+","+farbe.getBlue());
    }    
}
