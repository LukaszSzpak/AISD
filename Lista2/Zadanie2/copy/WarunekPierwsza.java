package Zadanie2.copy;

public class WarunekPierwsza implements Predicate {

	@Override
	public boolean accept(Object arg) {
		// TODO Auto-generated method stub
		int liczba = (int)arg;
		
		for (int i = 2; i <= (liczba / 2); i++) {
			
			if (liczba % i == 0) {
				return false;
			}
		}
		return true;
	}
	
}