package Zadanie1b;

public class Obsluga2 {
	
	public static void main(String [] args) {
		
		Hash tabHash = new Hash(5);
		
		tabHash.put(new Element(125, "el1"));
		tabHash.put(new Element(5, "el2"));
		tabHash.put(new Element(12, "el4"));
		tabHash.put(new Element(5635, "el5"));
		tabHash.put(new Element(5923, "el6"));
		tabHash.put(new Element(632, "el7"));
		tabHash.put(new Element(659239, "el8"));
		Element elum = new Element(639, "el8");
		tabHash.put(elum);
		
		tabHash.dump();
		System.out.println("Zawiera: " + tabHash.containsKey(elum));
		System.out.println("Zawiera: " + tabHash.containsKey(new Element(5264, "nowy")));
		
	}
}