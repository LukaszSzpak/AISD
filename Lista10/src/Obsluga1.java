import java.awt.EventQueue;

public class Obsluga1 {

    public static void main(String [] args) {
        Tree BST = new Tree();

        BST.add(15);
        BST.add(5);
        BST.add(54);
        BST.add(32);
        BST.add(1);
        BST.add(8);
        BST.add(3);
        BST.add(9);
        BST.add(21);

        Look look = new Look(BST.getRoot());

        EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MyFrame(look);
			}
		});


        System.out.println("Wyświetalnie inOrder: ");
        BST.inOrder();

        System.out.println("\nWyświetlanie preOrder");
        BST.preOrder();

        System.out.println("\nWyświetlanie postOrder");
        BST.postOrder();

        System.out.println("\nNajmniejszy element: " + BST.minElement());
        System.out.println("Największy element: " + BST.maxElement());
        System.out.println("Klucz 11: " + BST.findKey(11));
        System.out.println("Klucz 8: " + BST.findKey(8));
        System.out.println("Ilość liści: " + BST.iloscLisci());
        System.out.println("Ilosc wezlow: " + BST.iloscWezlow());
        System.out.println("Wysokosc drzewa: " + BST.getWysokoscDrzewa());

        Gui gui = new Gui(BST);
        gui.run();
    }
}