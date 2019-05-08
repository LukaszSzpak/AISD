

public class Towar {
	
	private String nazwa;
	private int ilosc;
	private int cena;
	private int wartosc;
	
	public Towar(String nazwa, int ilosc, int cena) {
		this.nazwa = nazwa;
		this.ilosc = ilosc;
		this.cena = cena;
		this.wartosc = cena*ilosc;
	}
	
	public Towar() {
		
	}
	
	
	//get'ery
	
	public String getNazwa() {
		return this.nazwa;
		
	}
	
	public int getIlosc() {
		return this.ilosc;
		
	}
	
	public int getCena() {
		return this.cena;
		
	}
	
	public int getWartosc() {
		return this.wartosc;
		
	}
	
	//set'ery
	
	public void setCena(int cena) {
		this.cena = cena;
		this.wartosc = this.cena * this.ilosc;
	}
	
	//metody
	
	public String toString() {
		return this.nazwa + " " + this.cena + " " + this.ilosc + " " + this.wartosc;
		
	}
	
	public boolean equals(Towar towar) {
		
		if (this.nazwa.equals(towar.nazwa) && this.cena == towar.cena && this.ilosc == towar.ilosc)
			return true;
		
		return false;
	}
}