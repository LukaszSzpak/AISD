package Zadanie;

public class Analiza {
	
	private long iloscPorownan;
	private long iloscPrzepisan;
	
	public Analiza() {
		this.iloscPorownan = 0;
		this.iloscPrzepisan = 0;
	}
	
	public long getIloscPorownan() {
		return this.iloscPorownan;
	}
	
	public long getIloscPrzepisan() {
		return this.iloscPrzepisan;
	}
	
	public void zeruj() {
		this.iloscPorownan = 0;
		this.iloscPrzepisan = 0;
	}
	
	public void zwiekszPorownanie(long ilosc) {
		this.iloscPorownan += ilosc;
	}
	
	public void zwiekszPrzepisanie(long ilosc) {
		this.iloscPrzepisan += ilosc;
	}
}