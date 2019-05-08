import java.util.Iterator;

public class Iter<T> implements Iterator<T> {
	
	private int pozycja;
	private int dlugosc;
	private List<T> lista;
	
	public Iter(List<T> lista) {
		this.lista = lista;
		this.pozycja = 0;
		this.dlugosc = lista.size();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		
		if (this.pozycja < this.dlugosc)
			return true;
		
		return false;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		
		return this.lista.get(pozycja++);
	}
	
}