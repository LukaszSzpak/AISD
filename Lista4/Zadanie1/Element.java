package Zadanie1;

public class Element<T> {
	
	private T value;
	private Element<T> next;
	
	public Element (T value, Element<T> next) {
		this.value = value;
		this.next = next;
	}
	
	//get'ery
	
	public T getValue() {
		return this.value;
	}
	
	public Element<T> getNext() {
		return this.next;
	}
	
	//set'ery
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public void setNext(Element<T> next) {
		this.next = next;
	}
}