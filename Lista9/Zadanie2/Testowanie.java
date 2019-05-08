package Zadanie2;

import java.util.Random;

public class Testowanie {
	public HashLiniowy hashLin;
	public HashPodwojny hashPod;
	public Analiza anal;
	
	public Testowanie(int liczba) {
		this.anal = new Analiza();
		this.hashLin = new HashLiniowy(liczba, anal);
		this.hashPod = new HashPodwojny(liczba, anal);
	}
	
	public void losuj(int liczba) {
		Random rand = new Random();
		
		for (int i = 0; i < liczba; i++) {
			Element tempEl = new Element(rand.nextInt(2000), "el" + i);
			
			this.hashLin.put(tempEl);
			this.hashPod.put(tempEl);
		}
	}
}