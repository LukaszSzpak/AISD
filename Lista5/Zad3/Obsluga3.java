package Zad3;

import java.util.Scanner;

public class Obsluga3 {
	
	public static void main(String[] args) {
		
		Scanner odczyt = new Scanner(System.in);
		
		System.out.println("Podaj liczbe: ");
		int liczba = odczyt.nextInt();
		
		Stos<Integer> stos = new Stos<>(1);
		
		while (liczba > 0) {
			stos.push((int)(liczba % 2));
			liczba /= 2;
		}
		
		while (stos.size() > 0) {
			System.out.print(stos.pop());
		}
		
	}
}