import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoListeBeispiel {
	public static void main(String[] args) {
		
		List<Auto> autos = new ArrayList<Auto>();
		
		autos.add(new Auto("Mercedes", 2007));
		autos.add(new Auto("Audi A8", 2010));
		
		Collections.sort(autos, new SortMarke());
		
		System.out.println("Sortierung nach Fahrzeugmarke:");
		for (Auto a : autos) {
			System.out.println(a);
		}
		
		Collections.sort(autos, new SortInv());
		
		System.out.println("\nSortierung nach Jahr der Inverkehrssetzung:");
		for (Auto a : autos) {
			System.out.println(a);
		}
	}
}
