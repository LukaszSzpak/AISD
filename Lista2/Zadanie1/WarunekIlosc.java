package Zadanie1;

public class WarunekIlosc implements Predicate {
	
	private int ilosc;
	
	public WarunekIlosc(int ilosc) {
		this.ilosc = ilosc;
	}
	
	@Override
	public boolean accept(Object arg) {
		// TODO Auto-generated method stub
		Towar nowy = (Towar)arg;
		
		if (nowy.getIlosc() == this.ilosc)
			return true;
		return false;
	}
}