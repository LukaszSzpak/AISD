package Zadanie1;

public class Zad1 {
	
	public static void main(String [] args) {
		
		
		Kolejka<Integer> kolejka = new Kolejka<>();
		
		try {
			kolejka.get();
		} catch (EmptyQueueException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		kolejka.add(new Integer(10));
		kolejka.add(new Integer(20));
		kolejka.add(new Integer(30));
		kolejka.add(new Integer(40));
		
		System.out.println("Dlugosc kolejki: " + kolejka.size());
		
		int size = kolejka.size();
		
		for (int i = 0; i < size; i++) {
				
				try {
					System.out.println(kolejka.get());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		
		
	}
}