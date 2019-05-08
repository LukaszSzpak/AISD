package Zad2;

public class Stos<T> {
	public T[] tablica;
	private int pozycja;
	
	public Stos (int dlugosc) {
		this.tablica = (T[])(new Object[dlugosc]);
		this.pozycja = 0;
	}
	
	public void powieksz() {
		if (this.pozycja >= 0.8 * this.tablica.length) {
			
			T[] temp = (T[])(new Object[this.tablica.length*2]);
			
			for (int i = 0; i < this.tablica.length; i++) {
				temp[i] = this.tablica[i];
			}
			
			this.tablica = temp;
			
			return;
		}
	}
	
	public void pomniejsz() {
		if (this.pozycja <= this.tablica.length * 0.2) {
			
			T[] temp = (T[])(new Object[(int)(this.tablica.length*0.5)]);
			
			for (int i = 0; i < temp.length; i++) {
				temp[i] = this.tablica[i];
			}
			
			this.tablica = temp;
			
			return;
		}
	}
	
	public T pop() {
		
		this.pomniejsz();
		return this.tablica[--this.pozycja];
	}
	
	public int size() {
		return this.pozycja;
	}
	
	public void push(T Wartosc) {
		this.powieksz();
		this.tablica[this.pozycja] = Wartosc;
		pozycja++;
		
	}
	
	public T top() {
		return this.tablica[this.pozycja-1];
	}
	
}