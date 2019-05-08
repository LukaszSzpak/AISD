package Zadanie1;

public class Kolejka<T> {
	
	private Element<T> head;
	private Element<T> actual;
	
	public Kolejka() {
		head = null;
	}
	
	public void clear() {
		this.head = null;
	}
	
	public T get() throws EmptyQueueException{
		
		if (this.head == null) {
			throw new EmptyQueueException();
		}
		
		Element<T> temp = this.head;
		this.head = this.head.getNext();
		
		return temp.getValue();
	}
	
	public void add(T Value) {
		
		if (this.head == null) {
			this.head = new Element<T>(Value, null);
			return;
		}
		
		this.actual = this.head;
		
		while (this.actual.getNext() != null) {
			this.actual = this.actual.getNext();
		}

		this.actual.setNext(new Element<T>(Value, null));
	}
	
	public int size() {
		int size = 0;
		this.actual = this.head;
		
		while (this.actual != null) {
			this.actual = this.actual.getNext();
			size++;
		}
		
		return size;
	}
	
}

class EmptyQueueException extends Exception {
	
}