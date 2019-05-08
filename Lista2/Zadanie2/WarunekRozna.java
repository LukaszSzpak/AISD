package Zadanie2;

public class WarunekRozna implements Predicate {
	
	private int liczba;
	
	public WarunekRozna(int liczba) {
		this.liczba = liczba;
	}

	@Override
	public boolean accept(Object arg) {

		if ((int)(arg) != liczba)
			return true;
		return false;
	}
	
}