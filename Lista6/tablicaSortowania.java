package Zadanie;

import java.util.ArrayList;
import java.util.Comparator;

public class tablicaSortowania implements Comparator<Osoba>{
	
	private ArrayList<Comparator<Osoba>> tab;
	
	public tablicaSortowania (ArrayList<Comparator<Osoba>> tab) {
		this.tab = tab;
	}

	@Override
	public int compare(Osoba os1, Osoba os2) {
		// TODO Auto-generated method stub
		int wynik = 0;
		
		for (int i = 0; i < tab.size(); i++) {
			
			wynik = tab.get(i).compare(os1, os2);
			if (wynik != 0)
				return wynik;
		}	
		
		return wynik;
	}
	
}