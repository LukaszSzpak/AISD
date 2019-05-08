package Zadanie2.copy;

public interface Iterator<T> {
	
	public void first();
	
	public void last();
	
	public void next();
	
	public boolean isDone();
	
	public T current();
}