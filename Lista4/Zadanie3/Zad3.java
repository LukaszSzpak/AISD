package Zadanie3;

public class Zad3 {
	
	public static void main(String [] args) {
		
		
		Kolejka<Integer> kolejka = new Kolejka<>(5);
		
		int wartosc = 1;
		while (kolejka.canAdd()) {
			kolejka.add(new Integer(wartosc));
			wartosc *= 10;
		}
		
		if (kolejka.canGet()) {
			System.out.println(kolejka.get());
		}
		if (kolejka.canGet()) {
			System.out.println(kolejka.get());
		}
		
		if(kolejka.canAdd()) {
			kolejka.add(new Integer(76));
			kolejka.add(new Integer(586));
		}
		
		System.out.println("\n");
		while (kolejka.canGet()) {
			System.out.println(kolejka.get());
		}
		
	}
}