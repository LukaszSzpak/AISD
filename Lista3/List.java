public class List<T> {
	
	private Element<T> head;
	private Element<T> actual;
	
	public List() {
		head = null;
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
	
	public void clear() {
		this.head = null;
	}
	
	public void wyswietlListe() {
		
		System.out.println("\nWyswietlam liste: ");
		
		this.actual = this.head;
		
		while (this.actual != null) {
			System.out.println(this.actual.getValue().toString());
			this.actual = this.actual.getNext();		
		}
	}
	
	public T get(int index) {
		int licznik = 0;
		this.actual = this.head;
		
		while (licznik < index ) {
			this.actual = this.actual.getNext();
			licznik++;
		}
		
		return this.actual.getValue();
	}
	
	public void insert(int index, T Element) {
		
		if (this.head == null) {
			this.head = new Element<T>(Element, null);
			return;
		}
		
		int licznik = 0;
		this.actual = this.head;
		
		while (licznik < index - 1) {
			this.actual = this.actual.getNext();
			licznik++;
		}
		
		if (this.actual.getNext() == null) {
			this.actual.setNext(new Element<T>(Element, null));
			return;
		}
		
		Element<T> temp = this.actual;
		this.actual = new Element<T>(Element, temp);
		temp.setNext(temp);
		
	}
	
	public Element<T> delete(int index) {
		int licznik = 0;
		this.actual = this.head;
		
		while (licznik < index - 1) {
			this.actual = this.actual.getNext();
			licznik++;
		}
		
		Element<T> temp = this.actual.getNext();
		
		if (temp == null) {
			this.actual.setNext(null);
			
		} else if (this.actual == this.head) {
			this.head = temp;
			
		} else {
			this.actual.setNext(temp.getNext());
			
		}
		
		return temp;
	}
	

	public boolean delete(T Element) {
		this.actual = this.head;
		
		if(head == null) {
			return false;
		}
		
		if(this.head.getValue() == Element) {
			
			if (this.head.getNext() == null) {
				this.head = null;
				
			} else {
				this.head = this.head.getNext();
				
			}
			
			return true;
		}
		
		while (this.actual.getNext() != null && this.actual.getNext().getValue() !=  Element) {
			this.actual = this.actual.getNext();

		}
		
		if (this.actual.getNext().getValue() != Element) {
			return false;
		}
		
		if (this.actual.getNext() == null) {
			this.actual = null;
			return true;
		}

		this.actual.setNext(this.actual.getNext().getNext());
		return true;
		
	}
	
	public void set(int index, T Value) {
		
		int licznik = 0;
		this.actual = this.head;
		
		while (licznik < index ) {
			this.actual = this.actual.getNext();
			licznik++;
		}
		
		this.actual.setValue(Value);
	}
	
	public int IndexOf(T Value) {
		int licznik = 0;
		this.actual = this.head;
		
		while (this.actual.getValue() != Value) {
			this.actual = this.actual.getNext();
			
			if (this.actual == null) {
				return -1;
			}
			licznik++;
		}
		
		return licznik;
	}
	
	public boolean contains(T Value) {
		
		this.actual = this.head;
		
		while (this.actual.getValue() != Value) {
			this.actual = this.actual.getNext();
			
			if (this.actual == null) {
				return false;
			}
		}
		
		return true;
		
	}
}