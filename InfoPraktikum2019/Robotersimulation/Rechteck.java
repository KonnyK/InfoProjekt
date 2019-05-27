import java.awt.Color;

/**
 * Write a description of class Rechteck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rechteck
{
    private Punkt Pos = new Punkt();
    private int breite = 0;
    private int hoehe = 0;
    private String name = "";
    private Color farbe = Color.black;
    
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
    
    public Punkt getPos(){ return Pos; }
    public int getBreite(){ return breite; }
    public int getHoehe(){ return hoehe; }
    public String getName(){ return name; }
    public Color getFarbe(){ return farbe; }
    
    private boolean LinesIntersect(Punkt[] P)
    {
        if (P.length != 4) return true;
        boolean Y = (P[2].getY() <= P[0].getY() && P[0].getY() <= P[3].getY());
        boolean X = (P[0].getX() <= P[2].getX() && P[2].getX() <= P[1].getX());        
        return (X && Y);
    }
    
    public boolean ueberlappt(Rechteck R)
    {
        Punkt M1 = new Punkt(getPos().getX() + getBreite()/2, getPos().getY() + getHoehe()/2);
        Punkt M2 = new Punkt(R.getPos().getX() + R.getBreite()/2, R.getPos().getY() + R.getHoehe()/2);
        boolean X = Math.abs(M2.getX() - M1.getX()) <= (getBreite() + R.getBreite())/2;
        boolean Y = Math.abs(M2.getY() - M1.getY()) <= (getHoehe() + R.getHoehe())/2;
        return (X && Y);
        /*
        boolean Intersect = false;
        if (breite * hoehe > R.getBreite() * R.getHoehe()) return R.ueberlappt(this);
        Punkt[] R1 = new Punkt[]
        { 
            new Punkt(Pos.getX(), Pos.getY() + hoehe),
            new Punkt(Pos.getX(), Pos.getY())
        };
        for (int i = 0; i < 4; i++)
        {
            
            
            R1[0].addX(breite*((2-i)%2));
            R1[0].addY(hoehe*((i-1)%2));
            R1[1].addX(breite*((1-i)%2));
            R1[1].addY(hoehe*((2-i)%2));
            R1 = new Punkt[]
            {
                new Punkt(R1[0].getX() + breite*((2-i)%2), R1[0].getY() + hoehe*((i-1)%2)),
                new Punkt(R1[1].getX() + breite*((1-i)%2), R1[1].getY() + hoehe*((2-i)%2))
            };
            Punkt[] R2 = new Punkt[]
            { 
                new Punkt(R.getPos().getX(),R.getPos().getY() + R.getHoehe()),
                new Punkt(R.getPos().getX(), R.getPos().getY())
            };
            for (int j = 0; j < 4; j++)
            {
                R2[0].addX(R.getBreite()*((2-i)%2));
                R2[0].addY(R.getHoehe()*((i-1)%2));
                R2[1].addX(R.getBreite()*((1-i)%2));
                R2[1].addY(R.getHoehe()*((2-i)%2));
                R2 = new Punkt[]
                {
                    new Punkt(R2[0].getX() + R.getBreite()*((2-j)%2), R2[0].getY() + R.getHoehe()*((j-1)%2)),
                    new Punkt(R2[1].getX() + R.getBreite()*((1-j)%2), R2[1].getY() + R.getHoehe()*((2-j)%2))
                };
                Punkt P1 = new Punkt(Math.min(R1[0].getX(), R1[1].getX()), Math.min(R1[0].getY(), R1[1].getY()));
                Punkt P2 = new Punkt(Math.max(R1[0].getX(), R1[1].getX()), Math.max(R1[0].getY(), R1[1].getY()));
                Punkt P3 = new Punkt(Math.min(R2[0].getX(), R2[1].getX()), Math.min(R2[0].getY(), R2[1].getY()));
                Punkt P4 = new Punkt(Math.max(R2[0].getX(), R2[1].getX()), Math.max(R2[0].getY(), R2[1].getY()));                
                if (LinesIntersect(new Punkt[] { P1, P2, P3, P4 })) return true;
            }
        }
        if (Pos.isInRect(R)) return true;
        return false;
        Punkt P1 = new Punkt(Pos.getX() + breite, Pos.getY());
        Punkt P2 = new Punkt(Pos.getX() , Pos.getY() + hoehe);
        Punkt P3 = new Punkt(Pos.getX() + breite, Pos.getY() + hoehe);
        return (Pos.isInRect(R) || P1.isInRect(R) || P2.isInRect(R) || P3.isInRect(R));
        */
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

