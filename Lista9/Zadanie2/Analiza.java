package Zadanie2;

public class Analiza {
	public int liczbaChybionych;
	public int liczbaTrafionych;
	public int sprawdzenChybionych;
	public int sprawdzenTrafionych;
	
	public Analiza() {
		this.liczbaChybionych = 0;
		this.liczbaTrafionych = 0;
		this.sprawdzenChybionych = 0;
		this.sprawdzenTrafionych = 0;
	}
	
	public void zeruj() {
		this.liczbaChybionych = 0;
		this.liczbaTrafionych = 0;
		this.sprawdzenChybionych = 0;
		this.sprawdzenTrafionych = 0;
	}
	
	public void addLiczbaChybionych(int liczba) {
		this.liczbaChybionych += liczba;
	}
	
	public void addLiczbaTrafoncyh(int liczba) {
		this.liczbaTrafionych += liczba;
	}
	
	public void addSprawdzenChybionych(int liczba) {
		this.sprawdzenChybionych += liczba;
		
	}
	
	public void addSprawdzenTrafionych(int liczba) {
		this.sprawdzenTrafionych += liczba;
	}
	
	public void wyswietl() {
		System.out.println("Średnia sprawdze� trafionych: " + this.sprawdzenTrafionych*1.00 / this.liczbaTrafionych*1.00);
		System.out.println("Średnia sprawdze� chybionych: " + this.sprawdzenChybionych*1.00 / this.liczbaChybionych*1.00);
		System.out.println("Łaczna liczba sprawdze�: " + (this.sprawdzenChybionych + this.sprawdzenTrafionych) * 1.00 / 
				(this.liczbaChybionych + this.liczbaTrafionych) * 1.00);
	}
	
} 