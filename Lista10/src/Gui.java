import java.util.Scanner;

public class Gui {
    private Tree BST;
    private int wybranaOpcja = 0;

    public Gui(Tree BST) {
        this.BST = BST;
    }

    public void run() {

        do {
            System.out.println("Dostępne opcje: \n\t0 - exit\n\t1 - wyśiwetl drzewo\n\t2 - wyznacz nastepnika\n\t3 - wyznacz poprzednika\n\t4 - usuń wezeł");
    
             Scanner odczyt = new Scanner(System.in);
             this.wybranaOpcja = odczyt.nextInt();

             switch(this.wybranaOpcja) {
                 case(1):
                    this.BST.printTree();
                    break;
                 case(2): break;
                 case(3): break;
                 case(4): break;
             }

        } while (this.wybranaOpcja != 0);
    }
    
}