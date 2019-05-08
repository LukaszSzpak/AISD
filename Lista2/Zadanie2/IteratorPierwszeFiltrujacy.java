package Zadanie2;

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
		
		this.aktualna = this.poczatek;	
		this.next();
	}

	@Override
	public void last() {
		// TODO Auto-generated method stub
		
		this.aktualna = this.koniec;
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		
		while (!this.isDone()) {
			
			if (this.czyPierwsza() && this.Predicate.accept(this.aktualna)) {
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
	public Object current() {
		// TODO Auto-generated method stub
		
		return this.aktualna-1;
	}
	
	private boolean czyPierwsza() {
		
		for (int i = 2; i <= (this.aktualna / 2); i++) {
			
			if (this.aktualna % i == 0) {
				return false;
			}
		}
		
		return true;
		
	}
	
}