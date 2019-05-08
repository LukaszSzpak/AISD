package Zadanie;

import java.util.Comparator;

class poNazwisko implements Comparator<Osoba> {

		@Override
		public int compare(Osoba os1, Osoba os2) {
			// TODO Auto-generated method stub
			return os1.getNazwisko().compareTo(os2.getNazwisko());
		}
	}