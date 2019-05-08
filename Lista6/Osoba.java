package Zadanie;

public class Osoba {
	private String imie;
	private String nazwisko;
	private int wiek;
	
	public Osoba(String imie, String nazwisko, int wiek) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.wiek = wiek;
	}
	
	public String getImie() {
		return this.imie;
	}
	
	public String getNazwisko() {
		return this.nazwisko;
	}
	
	public int getWiek() {
		return this.wiek;
	}
	
	public String toString() {
		return this.nazwisko + " " + this.imie + " " + this.wiek;
	}
	
}