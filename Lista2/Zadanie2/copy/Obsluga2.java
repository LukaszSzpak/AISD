package Zadanie2.copy;

import java.util.Scanner;

public class Obsluga2 {
	
	@SuppressWarnings({ "rawtypes", "resource", "unchecked" })
	public static void main(String [] args) {
		
		int poczatek;
		int koniec;
		Scanner odczyt = new Scanner(System.in);
		
		System.out.println("Podaj poczatek i koniec zakresu: ");
		poczatek = odczyt.nextInt();
		koniec = odczyt.nextInt();
		
		System.out.println("Wszystkie liczby z zakresu: ");
		
		IteratorLiczbowy it = new IteratorLiczbowy(poczatek, koniec);
		
		while(!it.isDone()) {
			System.out.println(it.current());
			it.next();
		}
		
		
		System.out.println("Wszystkie liczby pierwsze z zakresu: ");
		
		IteratorPierwszeFiltrujacy itf = new IteratorPierwszeFiltrujacy(poczatek, koniec, new WarunekPierwsza());
		
		while (!itf.isDone()) {
			System.out.println(itf.current());
			itf.next();
		}
		
		itf.first();
		System.out.println("Pierwsza pierwsza: " + itf.current());
		
		itf.last();
		System.out.println("Ostatnia pierwsza: " + itf.current());
		
	}
}