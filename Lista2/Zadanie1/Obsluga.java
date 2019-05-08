package Zadanie1;

public class Obsluga {
	private Towar[] ListaTowaru;
	
	public Obsluga(int dlugosc) {
		ListaTowaru = new Towar[dlugosc];
	}
	
	public static void main(String [] args) {
		
		Obsluga akt = new Obsluga(5);
		
		
		akt.ListaTowaru[0] = new Towar("Bulka", 10, 1);
		akt.ListaTowaru[1] = new Towar("Chleb", 0, 4);
		akt.ListaTowaru[2] = new Towar("Maka", 85, 2);
		akt.ListaTowaru[3] = new Towar("Platki", 0, 17);
		akt.ListaTowaru[4] = new Towar("Ziemniak", 263, 1);
		
		akt.wyswietl();
		akt.zmienCene(500, akt.ListaTowaru[0]);
		akt.wyswietl();
		
		akt.wyswietlCena(20);
		
		akt.wyswietlIlosc(0);
		
	}
	
	public void zmienCene(int nowaCena, Towar towar) {
		
		ArrayIterator<Towar> it = new ArrayIterator<>(this.ListaTowaru);
		
		while (it.hasNext()) {
			Towar aktualny = (Towar)it.next();
			if(aktualny.equals(towar))
				aktualny.setCena(nowaCena);
		}
	}
	
	public void wyswietl() {
		System.out.println("\nLista towaru:");
		
		ArrayIterator<Towar> it = new ArrayIterator<>(this.ListaTowaru);
		
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	
	public void wyswietlCena(int cena) {
		
		@SuppressWarnings("unchecked")
		ArrayFilterIterator<Towar> it = new ArrayFilterIterator<Towar>(this.ListaTowaru, new WarunekCena(cena));
		
		System.out.println("\nLista towaru cena:");
		
		while (it.hasNext())
			System.out.println(it.next().toString());
	}
	
	public void wyswietlIlosc(int ilosc) {
		
		@SuppressWarnings("unchecked")
		ArrayFilterIterator<Towar> it = new ArrayFilterIterator<Towar>(this.ListaTowaru, new WarunekIlosc(ilosc));
		
		System.out.println("\nLista towaru ilosc:");
		
		while (it.hasNext())
			System.out.println(it.next().toString());
	}
	
}