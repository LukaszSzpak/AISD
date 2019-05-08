package Zad2;

public class Obsluga2 {
	
	public static void main(String [] args) {
		
		Stos<Integer> stos = new Stos<>(2);
		
		//System.out.println(stos.tablica.length);
		stos.push(new Integer(5));
		stos.push(new Integer(10));
		stos.push(new Integer(3));
		//System.out.println(stos.tablica.length);
		stos.push(new Integer(55));
		stos.push(new Integer(235));
		//System.out.println(stos.tablica.length);
		
		while (stos.size() > 0) {
			System.out.println(stos.pop());
		}
		
	}
}