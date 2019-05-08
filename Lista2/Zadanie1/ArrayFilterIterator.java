package Zadanie1;

import java.util.Iterator;

public class ArrayFilterIterator<T> implements Iterator<T> {

	private T[] Tablica;
	private Predicate<T> Predicate;
	private int pozycja;
	private T nextElement;
	
	public ArrayFilterIterator(T[] Tablica, Predicate<T> Predicate) {
		this.Tablica = Tablica;
		this.pozycja = 0;
		this.Predicate = Predicate;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		return this.nextElement;
		
	}
	
	@Override
	public boolean hasNext() {
		while(this.pozycja < this.Tablica.length) {
			if((boolean)(Predicate.accept(Tablica[this.pozycja]))) {
				this.nextElement = this.Tablica[this.pozycja++];
				return true;
			} else
				this.pozycja++;
				
		}
		return false;
	}
	
}