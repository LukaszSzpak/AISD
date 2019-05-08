package Zadanie1b;

public class Element {
	
	private int klucz;
	private String wartosc;
	
	
	public Element(int klucz, String wartosc) {
		this.klucz = klucz;
		this.wartosc = wartosc;
	}
	
	public int getKlucz() {
		return this.klucz;
	}
	
	public String toString() {
		return "klucz: " + this.klucz + " wartoœæ: " + this.wartosc;
	}
}