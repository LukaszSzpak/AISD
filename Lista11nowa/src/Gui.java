import java.util.Scanner;

public class Gui {
    private Tree BST;
    private int wybranaOpcja;
    private Scanner odczyt;

    public Gui(Tree BST) {
        this.BST = BST;
        odczyt = new Scanner(System.in);
    }

    public void run() {
        do {
            System.out.println("Podaj operację do wykonania:" +
                                "\n\t0 - exit" +
                                "\n\t1 - in-order" +
                                "\n\t2 - pre-order" +
                                "\n\t3 - post-order" +
                                "\n\t4 - szukaj elementu" +
                                "\n\t5 - parametry drzewa" +
                                "\n\t6 - paramatery podanego elementu" +
                                "\n\t7 - graficznie wyswietl" +
                                "\n\t8 - drzewo poziomami");
        
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
                    BST.wyswietlParamteryDrzewa(null);
                    break;
                case(6):
                    this.parametry();
                    break;
                case(7):
                    BST.printTree();
                    break;
                case(8):
                    BST.printTreeLevels();
                    break;
            }

        } while (this.wybranaOpcja != 0);
        
        odczyt.close();
    }

    public void szukaj() {
        System.out.println("Podaj szukany klucz:");
        int szukany = odczyt.nextInt();

        System.out.println(BST.findKey(szukany));
    }

    public void parametry() {
        System.out.println("Podaj klucz do wyswietlenia parametrow");
        int szukany = odczyt.nextInt();

        BST.wyswietlParametryElementu(szukany);
    }
}