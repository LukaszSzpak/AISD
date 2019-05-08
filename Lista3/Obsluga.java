public class Obsluga {
	
	public static void main (String [] args) {
		
		List<Towar> lista = new List<>();
		
		lista.insert(0, new Towar("Bulka", 10, 1));
		lista.insert(1, new Towar("Chleb", 0, 4));
		lista.insert(2, new Towar("Maka", 85, 2));
		lista.insert(3, new Towar("Platki", 0, 17));
		lista.insert(4, new Towar("Ziemniak", 263, 1));
		
		System.out.println("Dlugosc listy: " + lista.size());
		lista.wyswietlListe();
		
		System.out.println(lista.get(3).toString());
		
		lista.delete(0);
		lista.wyswietlListe();
		lista.delete(lista.get(2));
		lista.wyswietlListe(); 
		
		System.out.println("\nPozycja: " + lista.IndexOf(lista.get(2)));
		System.out.println("Czy jest: " + lista.contains(lista.get(0)));
		System.out.println("Czy jest: " + lista.contains(new Towar("Jajko", 2, 20)));
		
		Iter<Towar> it = new Iter<>(lista);
		
		
		System.out.println("\nWyswietlam iteratorem: ");
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
		
	}
}