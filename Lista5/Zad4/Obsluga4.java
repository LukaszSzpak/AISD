package Zad4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Obsluga4 {
	
	public static void main(String[] args) {
		
		Stos<Integer> stos = new Stos<>(1);
		
		try {
			Scanner odczyt = new Scanner(new FileReader(new File("ONP.txt")));
			
			String linia = odczyt.nextLine();
			String[] stringi = linia.split(" ");
			
			for (int i = 0; i < stringi.length; i++) {
				
				try {
					int liczba = Integer.parseInt(stringi[i]);
					
					stos.push(new Integer(liczba));
					
				} catch (Exception ex) {
					
					int licz1 = stos.pop();
					int licz2 = stos.pop();
					
					if (stringi[i].equals("+")) {
						stos.push(new Integer(licz1 + licz2));
						
					} else if (stringi[i].equals("-")) {
						stos.push(new Integer((-licz2) + licz1));
						
					} else if (stringi[i].equals("*")) {
						stos.push(new Integer(licz1 * licz2));
						
					}
					
				}
				
			}
			
			System.out.println("Wynik: " + stos.pop());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}