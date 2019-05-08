package Zadanie1;

public class Analiza {
	private int liczbaChybionych;
	private int liczbaTrafionych;
	private int porownaniaChybione;
	private int porownaniaTrafione;
	
	public Analiza() {
		this.liczbaChybionych = 0;
		this.liczbaTrafionych = 0;
		this.porownaniaChybione = 0;
		this.porownaniaTrafione = 0;
	}
	
	public void zeruj() {
		this.liczbaChybionych = 0;
		this.liczbaTrafionych = 0;
		this.porownaniaChybione = 0;
		this.porownaniaTrafione = 0;
	}
	
	public void addLiczbaChybionych(int liczba) {
		this.liczbaChybionych += liczba;
	}
	
	public void addLiczbaTrafionych(int liczba) {
		this.liczbaTrafionych += liczba;
	}
	
	public void addPorownaniaChybione(int liczba) {
		this.porownaniaChybione += liczba;
	}
	
	public void addPorownaniaTrafione(int liczba) {
		this.porownaniaTrafione += liczba;
	}
	
	public void wyswietl() {
		System.out.println("Trafione: " + this.liczbaTrafionych + " Liczba chybionych: " + this.liczbaChybionych);
		System.out.println("Œrednia chybionych: " + this.porownaniaChybione*1.00/this.liczbaChybionych*1.00);
		System.out.println("Œrednia trafionych: " + this.porownaniaTrafione*1.00/this.liczbaTrafionych*1.00);
		System.out.println("Œrednia: " + (this.porownaniaChybione + this.porownaniaTrafione) / (this.liczbaChybionych + this.liczbaTrafionych));
	}
}