package Zadanie;

import java.util.ArrayList;
import java.util.Comparator;

public class Obsluga {
	
	private Osoba[] tablica;
	private Insert<Osoba> sort;
	private Select<Osoba> selSort;
	
	public Obsluga() {
		tablica = new Osoba[5];
		sort = new Insert<>();
		selSort = new Select<>();
		
		tablica[0] = new Osoba("anna", "ptak", 10);
		tablica[1] = new Osoba("anna", "ptak", 5);
		tablica[2] = new Osoba("hanna", "kow", 52);
		tablica[3] = new Osoba("bunia", "kow", 26);
		tablica[4] = new Osoba("jan", "lub", 5);
	}
	
	public static void main(String []args) {
		
		Obsluga Obsluga = new Obsluga();
		
		Obsluga.poWieku();
		Obsluga.poNazwisku();
		Obsluga.poImieniu();
		Obsluga.sortZlozona();
		Obsluga.sortTablica();
		
	} 
	
	public void poWieku() {
		System.out.println("Sortowanie po wieku: ");
		
		selSort.selectSort(tablica, new poWiek());
		
		this.wyswietl();
	}
	
	public void poNazwisku() {
		System.out.println("\nSortowanie po nazwisku: ");
		
		sort.insertSort(tablica, new poNazwisko());
		
		this.wyswietl();
	}
	
	public void poImieniu() {
		System.out.println("\nSortowanie po imieniu: ");
		
		sort.insertSort(tablica, new poImie());
		
		this.wyswietl();
	}
	
	public void sortZlozona() {
		System.out.println("\nSortowanie z³o¿one: ");
		
		
		sort.insertSort(tablica, new zlozonaMetoda());
		
		this.wyswietl();
	}
	
	public void sortTablica() {
		System.out.println("\nSortowanie z³o¿one tablica: ");
		
		ArrayList<Comparator<Osoba>> list = new ArrayList<>();
		
		list.add(new poWiek());
		list.add(new poNazwisko());
		
		sort.insertSort(tablica, new tablicaSortowania(list));
		
		this.wyswietl();
	}
	
	public void wyswietl() {
		for (int i = 0; i < tablica.length; i++) {
			System.out.println(tablica[i].toString());
		}
	}
}