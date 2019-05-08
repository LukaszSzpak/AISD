package Zadanie3;

public class Kolejka<T> {
	private T[] tablica;
	private int dlugosc;
	private int wstaw;
	private int pobierz;
	
	@SuppressWarnings("unchecked")
	public Kolejka(int dlugosc) {
		this.dlugosc = dlugosc;
		this.wstaw = 0;
		this.pobierz = 0;
		this.tablica = (T[])(new Object[dlugosc]);
	}
	
	public boolean canAdd() {
		if (this.tablica[this.wstaw] != null) {
			
			return false;
		}
			
		return true;
	}
	
	public void nextAdd() {
		if (this.wstaw == this.dlugosc-1) {
			this.wstaw = 0;
		} else {
			this.wstaw++;
		}
	}
	
	public void add(T Value) {
		
		this.tablica[this.wstaw] = Value;
		this.nextAdd();
		
	}
	
	public boolean canGet() {
		
		if (this.tablica[this.pobierz] == null) {
			return false;
		}
		
		return true;
	}
	
	public void nextGet() {
		if (this.pobierz == this.dlugosc-1) {
			this.pobierz = 0;
		} else {
			this.pobierz++;
		}
	}
	
	public T get() {
		T temp = this.tablica[this.pobierz];
		this.tablica[this.pobierz] = null;
		this.nextGet();
		
		return temp;
	}
}