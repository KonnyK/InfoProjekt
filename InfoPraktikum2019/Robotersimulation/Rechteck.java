import java.awt.Color;

/**
 * Write a description of class Rechteck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rechteck extends Figur
{
    
    private String name = "";
    private int breite = 0;
    private int hoehe = 0;
    
    public Rechteck(){}
    
    public Rechteck(Punkt pos, int breite, int hoehe, String name, Color farbe)
    {
        setPos(pos);
        setBreite(breite);
        setHoehe(hoehe);
        setName(name);
        setFarbe(farbe);
    }
    
    public void setBreite(int breite){ this.breite = Math.abs(breite); }
    public void setHoehe(int hoehe){ this.hoehe = Math.abs(hoehe); }
    public void setName(String name){ this.name = name; }
    
    public int getBreite(){ return breite; }
    public int getHoehe(){ return hoehe; }
    public String getName(){ return name; }
    
    @Override
    public int minX(){return getPos().getX();}
    @Override
    public int maxX(){return getPos().getX() + breite;}
    @Override
    public int minY(){return getPos().getY();}
    @Override
    public int maxY(){return getPos().getY() + hoehe;}
    
    
    @Override
    public boolean ueberlappt(Rechteck R)
    {
        Punkt M1 = new Punkt(getPos().getX() + getBreite()/2, getPos().getY() + getHoehe()/2);
        Punkt M2 = new Punkt(R.getPos().getX() + R.getBreite()/2, R.getPos().getY() + R.getHoehe()/2);
        boolean X = Math.abs(M2.getX() - M1.getX()) <= (getBreite() + R.getBreite())/2;
        boolean Y = Math.abs(M2.getY() - M1.getY()) <= (getHoehe() + R.getHoehe())/2;
        return (X && Y);
    }
    
    public void ausgabeAttribute()
    {
        System.out.println("Rechteck-"+name+"-:");
        System.out.println("Pos:"+Pos.getX()+"|"+Pos.getY());
        System.out.println("Maße:"+breite+"x"+hoehe);
        System.out.println("Farbe(RGB):"+farbe.getRed()+","+farbe.getGreen()+","+farbe.getBlue());
    }    
}

