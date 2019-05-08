package Zadanie2.copy;

public class IteratorPierwszeFiltrujacy<T> implements Iterator<T> {
	
	private int poczatek;
	private int koniec;
	private int aktualna;
	private Predicate<T> Predicate;
	
	public IteratorPierwszeFiltrujacy(int poczatek, int koniec, Predicate<T> Predicate) {
		this.poczatek = poczatek+1;
		this.koniec = koniec+1;
		this.aktualna = poczatek+1;
		this.Predicate = Predicate;
	}
	
	
	@Override
	public void first() {
		// TODO Auto-generated method stub
		
		this.aktualna = this.poczatek-1;	
		this.next();
	}

	@Override
	public void last() {
		// TODO Auto-generated method stub
		this.aktualna = this.koniec-1;
		
		while (this.aktualna >= this.poczatek) {
			if (this.Predicate.accept(this.aktualna)) {
				this.aktualna--;
				break;
			}
			
			aktualna--;
		}
		this.aktualna += 2;
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		
		while (!this.isDone()) {
			
			if (this.Predicate.accept(this.aktualna)) {
				this.aktualna++;
				return;
			}
			this.aktualna++;
		}
		
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
		
		return (T) new Integer(this.aktualna-1);
	}
	
}