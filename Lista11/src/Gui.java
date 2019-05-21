import java.util.Scanner;

public class Gui {
    private Tree BST;
    private int wybranaOpcja;

    public Gui(Tree BST) {
        this.BST = BST;
    }

    public void run() {
        do {
            Scanner odczyt = new Scanner(System.in);
            System.out.println("Podaj operację do wykonania:" +
                                "\n\t0 - exit" +
                                "\n\t1 - in-order" +
                                "\n\t2 - pre-order" +
                                "\n\t3 - post-order" +
                                "\n\t4 - szukaj elementu" +
                                "\n\t5 - parametry drzewa" +
                                "\n\t6 - graficznie wyswietl");
        
            this.wybranaOpcja = odczyt.nextInt();

            switch(this.wybranaOpcja) {
                case(1):
                    System.out.println("Wyświetalnie inOrder: ");
                    BST.inOrder();
                    break;
                case(2):
                    System.out.println("\nWyświetlanie preOrder");
                    BST.preOrder();
                    break;
                case(3):
                    System.out.println("\nWyświetlanie postOrder");
                    BST.postOrder();
                    break;
                case(4):
                    this.szukaj();
                    break;
                case(5):
                    System.out.println("Ilość liści: " + BST.iloscLisci());
                    System.out.println("Ilosc wezlow: " + BST.iloscWezlow());
                    System.out.println("Wysokosc drzewa: " + BST.getWysokoscDrzewa());
                    break;
                case(6):
                    BST.printTree();
                    break;
            }

        } while (this.wybranaOpcja != 0);
        
    }

    public void szukaj() {
        Scanner odczyt = new Scanner(System.in);
        System.out.println("Podaj szukany klucz:");
        int szukany = odczyt.nextInt();

        System.out.println(BST.findKey(szukany));
    }
}