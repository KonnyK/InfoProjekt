
public class Auto {
	private String marke;
	private int inv;
	
	public Auto(String m, int i) {
		this.marke = m;
		this.inv = i;
	}

	public String getMarke() {
		return this.marke;
	}
	
	public int getInv() {
		return this.inv;
	}
	
	public String toString() {
		return this.marke + " (" + this.inv + ")";
	}
}
