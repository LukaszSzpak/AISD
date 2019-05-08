package Zadanie2;

public class Kolejka<T> {
	
	private T[] tablica;
	private int dlugoscStworzona;
	private int dlugoscAktualna;
	
	@SuppressWarnings("unchecked")
	public Kolejka(int dlugosc) {
		tablica = (T[])(new Object[5]); 
		this.dlugoscStworzona = dlugosc;
		this.dlugoscAktualna = 0;
	}
	
	public void clear() {
		this.dlugoscAktualna = 0;
	}
	
	public void enqueue(T Value) throws FullQueueException {
		
		if (this.dlugoscAktualna < this.dlugoscStworzona) {
			this.tablica[this.dlugoscAktualna] = Value;
			this.dlugoscAktualna++;
			
		} else {
			throw new FullQueueException();
		}
	}
	
	public T dequeue() throws EmptyQueueException {
		
		if (this.dlugoscAktualna == 0) {
			throw new EmptyQueueException();
		}
		
		T temp = this.tablica[0];
		
		for (int i = 1; i < this.dlugoscAktualna; i++) {
			this.tablica[i-1] = this.tablica[i];
		}
		
		this.dlugoscAktualna--;
		
		return temp;
	}
	
	public int size() {
		return this.dlugoscAktualna;
	}
	
	public boolean isEmpty() {
		return this.dlugoscAktualna == 0;
	}
	
}

class FullQueueException extends Exception {
	
}

class EmptyQueueException extends Exception {
	
}