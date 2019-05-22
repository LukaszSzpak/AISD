import java.util.concurrent.ConcurrentLinkedQueue;

public class Tree {

    private Element root;
    private Element parent;
    private Element sentinel;
    private int iloscLisci;
    private int iloscWezlow;
    private int wysokoscDrzewa;

    private static final boolean BLACK = true;
    private static final boolean RED = false;

        /*
            Utowrzenie drzewa
        */

    public Tree() {
        this.root = null;
        this.sentinel = new Element(0);
    }

        /*
            Dodanie elementu do drzewa
        */

    public void add(int key) {

        if (this.root == null) {
            this.root = new Element(key);
            this.root.setLeft(this.sentinel);
            this.root.setRight(this.sentinel);
            return;
        }

        Element temp = this.root;
        this.parent = null;
        while(temp != this.sentinel) {

            if(temp.getKey() == key)
                break;

            if(key < temp.getKey()) {
                this.parent = temp;
                temp = temp.getLeft();
            } else {
                this.parent = temp;
                temp = temp.getRight();
            }               
        }

        Element newEl = new Element(key);

        if (key < this.parent.getKey()) {
            this.parent.setLeft(newEl);
            newEl.setParent(this.parent);
        } else {
            this.parent.setRight(newEl);
            newEl.setParent(this.parent);
        }

        newEl.setColor(RED);
        newEl.setLeft(this.sentinel);
        newEl.setRight(this.sentinel);

        this.CheckTree(newEl);
    }

        /*
            Sprawdzenie i naprawa drzewa
        */

 
    private void CheckTree(Element begin) {
        Element node = begin;
        Element parent = node.getParent();

        if (parent == null) {
            node.setColor(BLACK);
            return;      
        }

        if (parent.getColor() == BLACK)
            return;

        Element grandParent = node.getGrandParent();
        Element uncle = node.getUncle(grandParent);
            
        if (parent.getColor() == RED && uncle.getColor() == RED) {

            parent.setColor(BLACK);
            uncle.setColor(BLACK);
            if (grandParent != null) {
                grandParent.setColor(RED);
                this.CheckTree(grandParent);
            }
            return;
        }

        if (parent.getColor() == RED && uncle.getColor() == BLACK) {

            if (node == parent.getRight() && parent == grandParent.getLeft() ) {
                // right-left
                rotateLeft(parent);

                node = node.getLeft();
                parent = node.getParent();
                grandParent = node.getGrandParent();
                uncle = node.getUncle(grandParent);

            } else if (node == parent.getLeft() && parent == grandParent.getRight()) {
                // left-right
                rotateRight(parent);

                node = (Element) node.getRight();
                parent = (Element) node.getParent();
                grandParent = node.getGrandParent();
                uncle = node.getUncle(grandParent);
            }
        }

        if (parent.getColor() == RED && uncle.getColor() == BLACK){

            parent.setColor(BLACK);
            grandParent.setColor(RED);
            if (node == parent.getLeft() && parent == grandParent.getLeft()){
                // left-left
                rotateRight(grandParent);
            } else if (node == parent.getRight() && parent == grandParent.getRight()) {
                // right-right
                rotateLeft(grandParent);
            }
        }
    }

        /* 
            Rotacja w lewo
        */

    private void rotateLeft(Element node) {
        Element parent = node.getParent();
        Element greater = node.getRight();
        Element lesser = greater.getLeft();

        greater.setLeft(node);
        node.setParent(greater);
        node.setRight(lesser);

        if (lesser != null)
            lesser.setParent(node);

        if (parent!=null) {
            if (node == parent.getLeft()) {
                parent.setLeft(greater);
            } else if (node == parent.getRight()) {
                parent.setRight(greater);
            } else {
                throw new RuntimeException("ups nie mam rodzica - sorki :(");
            }
            greater.setParent(parent);
        } else {
            root = greater;
            root.setParent(null);
        }
    }
        /*
            Rotacja w prawo
        */

    protected void rotateRight(Element node) {
        Element parent = node.getParent();
        Element lesser = node.getLeft();
        Element greater = lesser.getRight();

        lesser.setRight(node);
        node.setParent(lesser);
        node.setLeft(greater);

        if (greater != null)
            greater.setParent(node);

        if (parent!=null) {
            if (node == parent.getLeft()) {
                parent.setLeft(lesser);
            } else if (node == parent.getRight()) {
                parent.setRight(lesser);
            } else {
                throw new RuntimeException("ups nie mam rodzica - sorki :(");
            }
            lesser.setParent(parent);
        } else {
            root = lesser;
            root.setParent(null);
        }
    }

    /* 
        Metoda do wyswietlenia drzewa poziomami
    */

    public void printTreeLevels() {
    	Element temp = root;
        ConcurrentLinkedQueue<Element> list = new ConcurrentLinkedQueue<Element>();
        
    	while(temp.getRight() != this.sentinel || temp.getLeft() != this.sentinel || !list.isEmpty()) {
    	if(!list.contains(temp))
            list.add(temp);
            
    	if(temp.getLeft() != this.sentinel && !list.contains(temp.getLeft()))
            list.add(temp.getLeft());
        
    	if(temp.getRight() != this.sentinel && !list.contains(temp.getRight()))
            list.add(temp.getRight());

        System.out.println(list.poll().toString());
        
    	if(list.isEmpty())
            break;
            
    	temp = list.peek();
    	
        }
    }

        /*
            Metoda IN-ORDER do wyświetlania drzewa
        */

    public void inOrder() {
        this.inOrder(this.root);
    }

    private void inOrder(Element element) {

        if(element == null || element.getKey() == 0) {
            return;
        }

        inOrder(element.getLeft());
        System.out.println(element.toString());
        inOrder(element.getRight());

    }
        /*
            Metoda PRE-ORDER do wyświetlnia drzewa
        */

    public void preOrder() {
        this.preOrder(this.root);
    }

    private void preOrder(Element element) {
        if (element == null || element.getKey() == 0) {
            return;
        }

        System.out.println(element.toString());
        this.preOrder(element.getLeft());
        this.preOrder(element.getRight());
    }
        /*
            Metoda POST-ORDER do wyświetlania drzewa
        */

    public void postOrder() {
        this.postOrder(this.root);
    }

    private void postOrder(Element element) {
        if (element == null || element.getKey() == 0) {
            return;
        }

        this.postOrder(element.getLeft());
        this.postOrder(element.getRight());
        System.out.println(element.toString());
    }

        /* 
            Metoda wyszukanie klucza w drzewie
        */

    public int findKey(int key) {
        
        Element temp = this.root;
        while(true) {
            if(temp == null || (temp.getLeft() == null && temp.getRight() == null))
                return -1;

            if(temp.getKey() == key) {
                return temp.getKey();
            }

            if(key < temp.getKey()) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
    }

        /*
            Metoda znajdująca element drzewa po kluczu
        */

    private Element findElementByKey(int key) {
        
        Element temp = this.root;
        while(true) {
            if(temp == this.sentinel || (temp.getLeft() == this.sentinel && temp.getRight() == this.sentinel))
                return null;

            if(temp.getKey() == key) {
                return temp;
            }

            if(key < temp.getKey()) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
    }

        /*
            Metoda zliczająca ilość liści
        */

    public int getIloscLisci() {
        this.iloscLisci = 0;
        this.getIloscLisci(this.root);
        return this.iloscLisci;
    }

    private int iloscLisci(Element element) {
        this.iloscLisci = 0;
        this.getIloscLisci(element);
        return this.iloscLisci;
    }

    private void getIloscLisci(Element element) {
        if (element == null || element.getKey() == 0) {
            return;
        }

        if (element.getLeft() == this.sentinel && element.getRight() == this.sentinel) {
            this.iloscLisci++;
        }

        this.getIloscLisci(element.getLeft());
        this.getIloscLisci(element.getRight());
    }

        /*
            Metoda zliczająca ilość wezlow
        */

    public int getIloscWezlow() {
        this.iloscWezlow = 0;
        this.getIloscWezlow(this.root);
        return this.iloscWezlow;
    }

    private int iloscWezlow(Element element) {
        this.iloscWezlow = 0;
        this.getIloscWezlow(element);
        return this.iloscWezlow;
    }

    private void getIloscWezlow(Element element) {
        if (element == null || element.getKey() == 0) {
            return;
        }

        if (element.getLeft() != this.sentinel || element.getRight() != this.sentinel) {
            this.iloscWezlow++;
        }

        this.getIloscWezlow(element.getLeft());
        this.getIloscWezlow(element.getRight());
    }

        /*
            Metoda obliczająca wysokość drzewa
        */

    public int getWysokoscDrzewa() {
        this.wysokoscDrzewa = 0;
        this.obliczWysokoscDrzewa(this.root, 0);
        return this.wysokoscDrzewa;
    }

    private int getWysokoscDrzewa(Element element) {
        this.wysokoscDrzewa = 0;
        this.obliczWysokoscDrzewa(element, 0);
        return this.wysokoscDrzewa;
    }

    private void obliczWysokoscDrzewa(Element element, int wysokosc) {
        if (element == null || element.getKey() == 0) {
            if (wysokosc-1 > this.wysokoscDrzewa) {
                this.wysokoscDrzewa = wysokosc-1;
            }
            return;
        }

        this.obliczWysokoscDrzewa(element.getLeft(), wysokosc+1);
        this.obliczWysokoscDrzewa(element.getRight(), wysokosc+1);

    }

        /*
            Metoda wyswietlajaca parametry drzewa
        */

    public void wyswietlParamteryDrzewa(Element elem) {
        if (elem == null)
            elem = this.root;
        
        System.out.println("Wysokosc drzewa: " + this.getWysokoscDrzewa(elem));
        System.out.println("Wysokosc lewego poddrzewa: " + this.getWysokoscDrzewa(elem.getLeft()));
        System.out.println("Wysokosc prawego poddrzewa: " + this.getWysokoscDrzewa(elem.getRight()));
        System.out.println("Ilosc wezlow: " + this.iloscWezlow(elem));
        System.out.println("Ilosc wezlow lewego poddrzewa: " + this.iloscWezlow(elem.getLeft()));
        System.out.println("Ilosc wezlow prawego poddrzewa: " + this.iloscWezlow(elem.getRight()));
        System.out.println("Ilosc lisci: " + this.iloscLisci(elem));
        System.out.println("Ilosc lisci lewego podrzewa: " + this.iloscLisci(elem.getLeft()));
        System.out.println("Ilosc lisci prawego podrzewa: " + this.iloscLisci(elem.getLeft()));
    }

        /*
            Metoda wyswietlajaca parametry poddrzewa dla danego klucza elementu
        */
    
    public void wyswietlParametryElementu(int key) {
        Element elem = this.findElementByKey(key);

        if (elem != null && elem != this.sentinel) {
            this.wyswietlParamteryDrzewa(elem);
        } else {
            System.out.println("Brak wezła!");
        }
    }

        /*
            Metoda wyświetlająca graficznie drzewo
        */

    public void printTree() {
        this.printTree(this.root, 0);
    }

    private void printTree(Element element, int wysokosc) {
        if (element == null || element.getKey() == 0) {
            return;
        }
        
        this.printTree(element.getRight(), wysokosc+1);

        for(int i = 0; i < wysokosc; i++) {
            System.out.print("   ");
        }

        System.out.println(element.toString());

        this.printTree(element.getLeft(), wysokosc+1);
    }
}