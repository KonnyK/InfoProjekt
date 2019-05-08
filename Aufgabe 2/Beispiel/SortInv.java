import java.util.Comparator;

public class SortInv implements Comparator<Auto>{

	@Override
	public int compare(Auto a1, Auto a2) {
		return a1.getInv() - a2.getInv();
	}

}