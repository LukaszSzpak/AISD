package Zadanie2;

import java.io.IOException;

public class Zad2 {
	
	public static void main(String [] args) {
		
		Kolejka<Integer> kolejka = new Kolejka(5);
		
		try {
			kolejka.dequeue();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			kolejka.enqueue(new Integer(10));
			kolejka.enqueue(new Integer(20));
			kolejka.enqueue(new Integer(30));
			kolejka.enqueue(new Integer(40));
			kolejka.enqueue(new Integer(50));
		} catch (FullQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Dlugosc kolejki: " + kolejka.size());
		
		try {
			kolejka.enqueue(new Integer(60));
		} catch (FullQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Dlugosc kolejki: " + kolejka.size());
		
		while (!kolejka.isEmpty()) {
			try {
				System.out.println(kolejka.dequeue());
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}