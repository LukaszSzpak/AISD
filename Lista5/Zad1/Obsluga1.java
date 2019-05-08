package Zad1;

public class Obsluga1 {
	
	public static void main(String [] args) {
		
		Stack<String> stos = new Stack<String>();
		
		stos.push("jeden");
		stos.push("dwa");
		stos.push("trzy");
		
		while (!stos.isEmpty()) {
			try {
				System.out.println(stos.pop());
			} catch (EmptyStackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}