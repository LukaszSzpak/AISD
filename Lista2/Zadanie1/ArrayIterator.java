package Zadanie1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
	
	private T[] Tablica;
	private int pozycja;
	
	public ArrayIterator(T[] Tablica) {
		this.Tablica = Tablica;
		this.pozycja = 0;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		
		if (this.pozycja < this.Tablica.length)
			return true;
		
		return false;
	}

	@Override
	public T next() throws NoSuchElementException{
		// TODO Auto-generated method stub
		if(this.hasNext())
			return this.Tablica[this.pozycja++];
		else 
			throw new NoSuchElementException();
	}
	
}