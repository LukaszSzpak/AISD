package Zadanie1a;

public class Hash {
	
	private Element[] tablica;
	private int aktualnaIloscElementow;
	
	public Hash(int dlugosc) {
		this.tablica = new Element[dlugosc];
		this.aktualnaIloscElementow = 0;
	}
	
	public void put(Element element) {
		
		this.resize();
		int hash = this.generujHash(element) % this.tablica.length;
		
		while(tablica[hash] != null) {
			hash = (hash+1) % this.tablica.length;
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
	
	public void resize() {
		Element[] temp = this.tablica;
		
		if (this.tablica.length * 0.8 < this.aktualnaIloscElementow) {
			this.tablica = new Element[temp.length * 2];
			
			for (int i = 0; i < temp.length; i++) {
				
				if (temp[i] != null) {
					this.put(temp[i]);
					this.aktualnaIloscElementow--;
				}
				
			}
			
		}
		
		if (this.tablica.length * 0.2 > this.aktualnaIloscElementow) {
			this.tablica = new Element[temp.length / 2];
			
			for (int i = 0; i < temp.length; i++) {
				
				if (temp[i] != null) {
					this.put(temp[i]);
					this.aktualnaIloscElementow--;
				}
				
			}
		}
	}
	
	public int generujHash(Element element) {
		int hash = 0;
		int wartosc = element.getKlucz();
		
		while(wartosc > 0) {
			hash += wartosc%10;
			wartosc /= 10;
		}
		
		return hash;
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