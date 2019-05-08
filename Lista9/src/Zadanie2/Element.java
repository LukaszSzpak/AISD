package Zadanie2;

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
		return "klucz: " + this.klucz + " wartość: " + this.wartosc;
	}

	public boolean equals(Element element) {
		
		if(this.wartosc.equals(element.wartosc)) {
			return true;
		}
			

		return false;
	}
}