package Zadanie;

import java.util.Random;

public class Obsluga {
	
	private Analiza analiza;
	private int[] tab1;
	Merge Mergesort;
	Quick Quicksort;
	
	public Obsluga(Analiza analiza, int wielkosc) {
		this.analiza = analiza;
		this.tab1 = new int[wielkosc];
		Mergesort = new Merge(analiza);
		Quicksort = new Quick(analiza);
	}
	
	public static void main(String[] args) {
		
		System.out.println("Tablica 10 elementowa: "); 
		
		Obsluga obsluga = new Obsluga(new Analiza(), 10);
		obsluga.uruchom();
		
		System.out.println("\n\n\nTablica 100 elementowa: "); 
		
		Obsluga obsluga1 = new Obsluga(new Analiza(), 100);
		obsluga1.uruchom();
		
		System.out.println("\n\n\nTablica 500 elementowa: "); 
		
		Obsluga obsluga2 = new Obsluga(new Analiza(), 500);
		obsluga2.uruchom();
		
		System.out.println("\n\n\nTablica 1000 elementowa: "); 
		
		Obsluga obsluga3 = new Obsluga(new Analiza(), 1000);
		obsluga3.uruchom();
		
		System.out.println("\n\n\nTablica 2000 elementowa: "); 
		
		Obsluga obsluga4 = new Obsluga(new Analiza(), 2000);
		obsluga4.uruchom();
		
	}
	
	public void wyswietl() {
		
		System.out.println(" Ilosc przypisañ: " + this.analiza.getIloscPrzepisan() + "\n Ilosc porownan: " + this.analiza.getIloscPorownan());
	}
	
	public void wypelnijLosowymi() {
		Random gen = new Random();
		
		for (int i = 0; i < this.tab1.length; i++) {
			this.tab1[i] = gen.nextInt();
		}
	}
	
	public void wypelnijRosnaco() {
		for (int i = 0; i < this.tab1.length; i++) {
			this.tab1[i] = i+1;
		}
	}
	
	public void wypelnijMalejaco() {
		int j = this.tab1.length;
		
		for (int i = 0; i < this.tab1.length; i++) {
			this.tab1[i] = j;
			j--;
		}
	}
	
	public void sortowanieLosowe() {
		System.out.println("\nSortowanie losowe: \nMerge: ");
		this.wypelnijLosowymi();
		Mergesort.sort(this.tab1, 0, this.tab1.length-1);
		this.wyswietl();
		this.analiza.zeruj();
		
		System.out.println("\nQuick: ");
		this.wypelnijLosowymi();
		Quicksort.sort(this.tab1, 0, this.tab1.length-1);
		this.wyswietl();
		this.analiza.zeruj();
	}
	
	public void sortowanieMalejace() {
		System.out.println("\nSortowanie danych malejacych: \nMerge: ");
		this.wypelnijMalejaco();
		Mergesort.sort(this.tab1, 0, this.tab1.length-1);
		this.wyswietl();
		this.analiza.zeruj();
		
		System.out.println("\nQuick: ");
		this.wypelnijMalejaco();
		Quicksort.sort(this.tab1, 0, this.tab1.length-1);
		this.wyswietl();
		this.analiza.zeruj();
	}
	
	public void sortowanieRosnaco() {
		System.out.println("\nSortowanie danych rosnacych: \nMerge: ");
		this.wypelnijRosnaco();
		Mergesort.sort(this.tab1, 0, this.tab1.length-1);
		this.wyswietl();
		this.analiza.zeruj();
		
		System.out.println("\nQuick: ");
		this.wypelnijRosnaco();
		Quicksort.sort(this.tab1, 0, this.tab1.length-1);
		this.wyswietl();
		this.analiza.zeruj();
	}
	
	public void uruchom() {
		this.sortowanieLosowe();
		this.sortowanieRosnaco();
		this.sortowanieMalejace();
	}
}