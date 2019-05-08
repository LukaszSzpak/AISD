package Zadanie1;

import java.util.Random;

public class Obsluga1 {
	private int[] tab;
	private Bubble sort;
	private Analiza analiza;
	private int szukana;
	
	public Obsluga1(int wielkosc) {
		this.tab = new int[wielkosc];
		this.analiza = new Analiza();
		this.sort = new Bubble();
	}
	
	public static void main(String[] args) {
		
		Obsluga1 Obsluga = new Obsluga1(1000);
		Random rand = new Random();
		
		System.out.println("Szukanie liniowe: ");
		
		for (int i = 0; i < 100; i++) {
			Obsluga.uzupelnijLosowo();
			Obsluga.szukana = rand.nextInt(5000);
			Obsluga.szukajLiniowo();
		}
		
		Obsluga.analiza.wyswietl();
		Obsluga.analiza.zeruj();
		
		System.out.println("\n\nSzukanie binarne: ");
		
		for (int i = 0; i < 100; i++) {
			Obsluga.uzupelnijLosowo();
			Obsluga.szukana = rand.nextInt(5000);
			Obsluga.szukajBinarnie();
		}
			
		
		Obsluga.analiza.wyswietl();
		
	}
	
	public void uzupelnijLosowo() {
		Random rand = new Random();
		
		for (int i = 0; i < this.tab.length; i++) {
			this.tab[i] = rand.nextInt(5000);
		}
	}
	
	public void sortuj() {
		this.sort.sort(tab);
	}
	
	public void szukajLiniowo() {
		
		for (int i = 0; i < this.tab.length; i++) {
			if (this.tab[i] == this.szukana) {
				this.analiza.addPorownaniaTrafione(i);
				this.analiza.addLiczbaTrafionych(1);
				return;
			}
		}
		
		analiza.addLiczbaChybionych(1);
		analiza.addPorownaniaChybione(tab.length-1);
	}
	
	public void szukajBinarnie() {
		this.sortuj();
		
		int lewa = 0;
		int prawa = tab.length-1;
		int wynik = 0;

		while(lewa <= prawa) {
			int srodek = (lewa + prawa)/2;
			wynik++;
			
			if(tab[srodek] == szukana) {
				analiza.addLiczbaTrafionych(1);
				analiza.addPorownaniaTrafione(wynik);
				
				return;
			}
				
				
			if(tab[srodek] > szukana)
				prawa = srodek - 1;
			else
				lewa = srodek + 1;
		}
		
		analiza.addLiczbaChybionych(1);
		analiza.addPorownaniaChybione(wynik);
	}
	
}