package Zadanie;

import java.util.Comparator;

public class poWiek implements Comparator<Osoba> {

		@Override
		public int compare(Osoba os1, Osoba os2) {
			// TODO Auto-generated method stub
			if (os1.getWiek() > os2.getWiek())
				return 1;
			
			if (os1.getWiek() < os2.getWiek())
				return -1;
			
			return 0;
		}
		
	}