import java.awt.Color;

public class Rechteck
{
    Punkt position = new Punkt(0,0);
    int breite = 0;
    int laenge = 0;
    String bezeichnung = "";
    Color farbe = Color.black;
    
    public Rechteck()
    {
        bezeichnung = "";
        farbe = Color.black;
    }
    public Rechteck(Punkt position, int breite, int laenge, String bezeichnung, Color farbe)
    {
        this.position = position;
        this.breite = breite;
        this.laenge = laenge;
        this.bezeichnung = bezeichnung;
        this.farbe = farbe;
    }
    
    public Punkt setPosition(){return position;}
    public int setBreite(){return breite;}
    public int setlaenge(){return laenge;}
    public String setBezeichnung(){return bezeichnung;}
    public Color setFarbe(){return farbe;}
    
    public void setPosition(Punkt position){this.position = position;}
    public void setBreite(int breite){this.breite = breite;}
    public void setlaenge(int laenge){this.laenge = laenge;}
    public void setBezeichnung(String bezeichnung){this.bezeichnung = bezeichnung;}
    public void setFarbe(Color farbe)
    {
        if (farbe != Color.white) System.out.println("Rechteck kann nicht weiß sein!");
        else this.farbe = farbe;
    }    
    
    public void bewegeUm(int dx, int dy){position.bewegeUm(dx,dy);}
    public void bewegeUm(Punkt verschiebevektor){position.bewegeUm(verschiebevektor.getX(), verschiebevektor.getY());}
    
    public void ausgabeAttribute(){System.out.println("Rechteck: " + position.ausgabeAttribute() + "|" + breite + "|" + laenge + "|" + bezeichnung + "|" + farbe.getRGB());}
}
