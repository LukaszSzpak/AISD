package Zadanie;

import java.util.Comparator;

public class poImie implements Comparator<Osoba> {

		@Override
		public int compare(Osoba os1, Osoba os2) {
			// TODO Auto-generated method stub
			return os1.getImie().compareTo(os2.getImie());
		}	
	}