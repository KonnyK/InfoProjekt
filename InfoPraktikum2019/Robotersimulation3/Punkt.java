import java.lang.Math;

public class Punkt
{
    private int x = 0;
    private int y = 0;
    
    public Punkt(){}
    public Punkt(int X, int Y){x = X; y = Y;}
    
    public int getX(){ return x; }
    public int getY(){ return y; }
    public void setX(int x){ this.x = x; }
    public void setY(int y){ this.y = y; }    
    public void bewegeUm(int dx, int dy){ x += dx; y += dy; }
    public String ausgabeAttribute()
    { 
        String result = x + "|" + y;
        System.out.println("Punkt: " + result);
        return result;
    }
    public double gibAbstandPunkt(Punkt andererPunkt)
    {
        return Math.sqrt( Math.pow(x-andererPunkt.getX(), 2) + Math.pow(y-andererPunkt.getY(),2) );
    }  
}
