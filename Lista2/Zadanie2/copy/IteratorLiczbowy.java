package Zadanie2.copy;

public class IteratorLiczbowy<T> implements Iterator<T> {
	
	private int poczatek;
	private int koniec;
	private int aktualna;
	
	public IteratorLiczbowy(int poczatek, int koniec) {
		this.poczatek = poczatek;
		this.koniec = koniec;
		this.aktualna = poczatek;
	}
	
	
	@Override
	public void first() {
		// TODO Auto-generated method stub
		
		this.aktualna = this.poczatek;	
	}

	@Override
	public void last() {
		// TODO Auto-generated method stub
		this.aktualna = this.koniec;

	}

	@Override
	public void next() {
		// TODO Auto-generated method stub

		this.aktualna++;
		
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		
		if (this.aktualna > this.koniec)
			return true;
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T current() {
		// TODO Auto-generated method stub

		return (T) new Integer(this.aktualna);
	}
	
}