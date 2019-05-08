package Zadanie;

import java.util.Comparator;

public class zlozonaMetoda implements Comparator<Osoba> {

	@Override
	public int compare(Osoba os1, Osoba os2) {		
		// TODO Auto-generated method stub
		
		if (os1.getNazwisko().compareTo(os2.getNazwisko()) > 0) {
			return 1;		
		}
		
		if (os1.getNazwisko().compareTo(os2.getNazwisko()) < 0) {
			return -1;		
		}
		
		if (os1.getImie().equals(os2.getImie())) {
			if (os1.getWiek() == os2.getWiek())
				return 0;
			
			if (os1.getWiek() > os2.getWiek())
				return 1;
			
			return -1;
		}
		
		if (os1.getImie().compareTo(os2.getImie()) > 0) {
			return 1;
			
		}
				
		return -1;
	}
	
}