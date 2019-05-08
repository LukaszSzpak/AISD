package Zad1;

public class Stack<T> {
	
	private Element<T> head;
	
	public Stack() {
		head = null;
	}
	
	public T pop() throws EmptyStackException{
		
		if (this.head == null) {
			throw new EmptyStackException();
		}
		
		Element<T> temp = new Element<T>(this.head.getValue(), this.head.getNext());
		this.head = this.head.getNext();
		
		return temp.getValue();
	}
	
	public void push(T Value) {
		
		if (this.head == null) {
			this.head = new Element<T>(Value, null);
			return;
		}
		
		this.head = new Element<T>(Value, this.head);
	}
	
	public T top() throws EmptyStackException {
		
		if (this.head == null) {
			throw new EmptyStackException();
		}
		
		return this.head.getValue();
	}
	
	public boolean isEmpty() {
		
		return this.head == null;
	}
	
}

class EmptyStackException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}