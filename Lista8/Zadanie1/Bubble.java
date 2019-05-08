package Zadanie1;

public class Bubble {

	
	public void sort(int[] tab) {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length-1; j++) {
				if (tab[j] > tab[j+1]) {
					int temp = tab[j];
					tab[j] = tab[j+1];
					tab[j+1] = temp;
				}
			}
		}
	}
}