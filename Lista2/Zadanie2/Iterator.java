package Zadanie2;

public interface Iterator<T> {
	
	public void first();
	
	public void last();
	
	public void next();
	
	public boolean isDone();
	
	public Object current();
}