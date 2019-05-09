package Zadanie2;

import java.util.Random;

public class Testowanie {
	public HashLiniowy hashLin;
	public HashPodwojny hashPod;
	public Analiza anallin;
	public Analiza analpod;
	public int liczbaLosowanychLiczb;
	
	public Testowanie(int liczba, double zapelnienie) {
		this.anallin = new Analiza();
		this.analpod = new Analiza();
		this.hashLin = new HashLiniowy(liczba, anallin);
		this.hashPod = new HashPodwojny(liczba, analpod);
		this.liczbaLosowanychLiczb = (int)(liczba * zapelnienie);
	}
	
	public void losuj() {
		Random rand = new Random();
		

		for (int i = 0; i < this.liczbaLosowanychLiczb; i++) {
			int temp = rand.nextInt(1000);
			Element tempEl = new Element(temp, "el" + temp);
			this.hashLin.put(tempEl);
			this.hashPod.put(tempEl);
			
		}
	}

	public void sprawdz() {
		Random rand = new Random();
		
		for (int i = 0; i < this.liczbaLosowanychLiczb; i++) {
			int temp = rand.nextInt(1000);
			Element tempEl = new Element(temp, "el" + temp);
			
			this.hashLin.containsKey(tempEl);
			this.hashPod.containsKey(tempEl);
		}
	}

	public static void main(String [] args) {

		System.out.println("\n\nTestowanie dla 0.6: ");
		Testowanie test = new Testowanie(1000, 0.6);

		test.losuj();
		test.sprawdz();
		System.out.println("Liniowe:");
		test.anallin.wyswietl();
		System.out.println("Podwójne:");
		test.analpod.wyswietl();
		test.anallin.zeruj();
		test.analpod.zeruj();

		System.out.println("\n\nTestowanie dla 0.7: ");
		test = new Testowanie(1000, 0.7);

		test.losuj();
		test.sprawdz();
		System.out.println("Liniowe:");
		test.anallin.wyswietl();
		System.out.println("Podwójne:");
		test.analpod.wyswietl();
		test.anallin.zeruj();
		test.analpod.zeruj();

		System.out.println("\n\nTestowanie dla 0.9: ");
		test = new Testowanie(1000, 0.9);

		test.losuj();
		test.sprawdz();
		System.out.println("Liniowe:");
		test.anallin.wyswietl();
		System.out.println("Podwójne:");
		test.analpod.wyswietl();
		test.anallin.zeruj();
		test.analpod.zeruj();
	}
}