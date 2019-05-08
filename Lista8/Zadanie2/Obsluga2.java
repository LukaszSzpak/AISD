package Zadanie2;

public class Obsluga2 {
	
	public static void main(String[] args) throws EmptyQueueException {
		
		Heap kopiec = new Heap();
		
		System.out.println("Pierwsza porcja danych: ");
		
		kopiec.enqueue(new Integer(50));
		kopiec.enqueue(new Integer(5));
		kopiec.enqueue(new Integer(11));
		kopiec.enqueue(new Integer(35));
		kopiec.enqueue(new Integer(102));
		
		while (!kopiec.isEmpty()) {
			System.out.print(kopiec.dequeue() + " ");
		}
		
		System.out.println("\n\nDruga porcja danych: ");
		
		kopiec.enqueue(new Integer(50));
		kopiec.enqueue(new Integer(5));
		kopiec.enqueue(new Integer(11));
		kopiec.enqueue(new Integer(35));
		kopiec.enqueue(new Integer(102));
		
		kopiec.change(new Integer(6523), 2);
		
		while (!kopiec.isEmpty()) {
			System.out.print(kopiec.dequeue() + " ");
		}
		
	}
}