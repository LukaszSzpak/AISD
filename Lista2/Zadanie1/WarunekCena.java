package Zadanie1;

public class WarunekCena implements Predicate {
	
	private int cena;
	
	public WarunekCena(int cena) {
		this.cena = cena;
	}
	
	@Override
	public boolean accept(Object arg) {
		// TODO Auto-generated method stub
		Towar nowy = (Towar)arg;
		
		if (nowy.getCena() < cena)
			return true;
		return false;
	}
}