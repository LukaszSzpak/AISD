package Zadanie2;

import java.util.Scanner;

public class Obsluga2 {
	
	@SuppressWarnings("rawtypes")
	public static void main(String [] args) {
		
		int poczatek;
		int koniec;
		Scanner odczyt = new Scanner(System.in);
		
		System.out.println("Podaj poczatek i koniec zakresu: ");
		poczatek = odczyt.nextInt();
		koniec = odczyt.nextInt();
		
		
		System.out.println("Wszystkie liczby z zakresu: ");
		
		IteratorPierwsze it = new IteratorPierwsze(poczatek, koniec);
		
		while (!it.isDone()) {
			System.out.println(it.current());
			it.next();
		}
		
		System.out.println("Wszystkie liczby z zakresu bez 7: ");
		
		IteratorPierwszeFiltrujacy it2 = new IteratorPierwszeFiltrujacy(poczatek, koniec, new WarunekRozna(7));
		
		while (!it2.isDone()) {
			System.out.println(it2.current());
			it2.next();
		}
		
	}
}