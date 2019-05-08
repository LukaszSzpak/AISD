package Zadanie;

import java.util.Comparator;

public class Insert<T> {

	public void insertSort(T[] tab, Comparator<T> com) {
		
		T klucz;
		int j;
		
		for (int i = 1; i < tab.length; i++) {
			j = i;
			klucz = tab[i];
			
			while (j > 0 && com.compare(tab[j-1], klucz) > -1) {
				tab[j] = tab[j-1];
				j--;
			}
			
			tab[j] = klucz;
		}
		
	}
	
}