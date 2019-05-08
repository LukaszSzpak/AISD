package Zadanie2;

public class HashPodwojny {
	
	private Element[] tablica;
	private int aktualnaIloscElementow;
	private Analiza anal;
	
	public HashPodwojny(int dlugosc, Analiza anal) {
		this.tablica = new Element[dlugosc];
		this.aktualnaIloscElementow = 0;
		this.anal = anal;
	}
	
	public void put(Element element) {
		int hash = this.generujHash(element) % this.tablica.length;
		
		while(tablica[hash] != null) {
			hash = (hash + this.zapasowyHash(element)) % this.tablica.length;
		}
		
		this.tablica[hash] = element;
		this.aktualnaIloscElementow++;
	}
	
	public boolean containsKey(Element element) {
		int hash = this.generujHash(element) % this.tablica.length;
		
		while (this.tablica[hash] != null) {
			
			if (this.tablica[hash] == element) {
				return true;
			}
			hash = (hash + 1) % this.tablica.length;
		}
		
		return false;
	}
	
	public int size() {
		return this.tablica.length;
	}
	
	public boolean isEmpty() {
		return this.aktualnaIloscElementow==0;
	}
	
	public int generujHash(Element element) {
		int hash = 0;
		int wartosc = element.getKlucz();
		int mnoznik = 7;
		
		while(wartosc > 0) {
			hash += (wartosc%10) * mnoznik;
			wartosc /= 10;
			mnoznik *= 7;
		}
		
		return hash;
	}
	
	public int zapasowyHash(Element element) {
		
		return element.getKlucz()%11;
	}
	
	public void dump() {
		
		for (int i = 0; i < this.tablica.length; i++) {
			if (this.tablica[i] == null) {
				System.out.println("Pusto");
			} else {
				System.out.println(this.tablica[i].toString());
			}
		}
	}
}