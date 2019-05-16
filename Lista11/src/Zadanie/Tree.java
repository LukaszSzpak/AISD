public class Tree {

    private Element root;
    private Element parent;
    private int iloscLisci;
    private int iloscWezlow;
    private int wysokoscDrzewa;

    public Tree() {
        this.root = null;
    }

    public void add(int key) {

        if (this.root == null) {
            this.root = new Element(key);
            this.root.setColor(true);
            return;
        }

        Element temp = this.root;
        this.parent = null;
        while(temp != null) {

            if(temp.getKey() == key)
                return;

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

        this.changeColorWithParent();
        this.checkRotate(newEl);

    }

    public void checkRotate(Element element) {
        if(!this.parent.getColor() && !element.getColor()) {
            //ojciec jest czerwony i syn jest czerwony więc musimy cos z tym zrobić

        }
    }

    public void rotateStrightLeft() {

    }

    public void changeColorWithParent() {
        if (parent.getLeft() != null && parent.getRight() != null) {
            if (!parent.getLeft().getColor() && !parent.getRight().getColor()) {
                parent.setColor(false);
                parent.getLeft().setColor(true);
                parent.getRight().setColor(true);

                if (parent == this.root) {
                    parent.setColor(true);
                }
            }
        }
    }





        /*
            Metoda IN-ORDER do wyświetlania drzewa
        */

    public void inOrder() {
        this.inOrder(this.root);
    }

    private void inOrder(Element element) {

        if(element == null) {
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
        if (element == null) {
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
        if (element == null) {
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
            Metoda zliczająca ilość liści
        */

    public int iloscLisci() {
        this.iloscLisci = 0;
        this.iloscLisci(this.root);
        return this.iloscLisci;
    }

    private void iloscLisci(Element element) {
        if (element == null) {
            return;
        }

        if (element.getLeft() == null && element.getRight() == null) {
            this.iloscLisci++;
        }

        this.iloscLisci(element.getLeft());
        this.iloscLisci(element.getRight());
    }

        /*
            Metoda zliczająca ilość wezlow
        */

    public int iloscWezlow() {
        this.iloscWezlow = 0;
        this.iloscWezlow(this.root);
        return this.iloscWezlow;
    }

    private void iloscWezlow(Element element) {
        if (element == null) {
            return;
        }

        if (element.getLeft() != null || element.getRight() != null) {
            this.iloscWezlow++;
        }

        this.iloscWezlow(element.getLeft());
        this.iloscWezlow(element.getRight());
    }

        /*
            Metoda obliczająca wysokość drzewa
        */

    public int getWysokoscDrzewa() {
        this.wysokoscDrzewa = 0;
        this.obliczWysokoscDrzewa(this.root, 0);
        return this.wysokoscDrzewa;
    }

    private void obliczWysokoscDrzewa(Element element, int wysokosc) {
        if (element == null) {
            if (wysokosc-1 > this.wysokoscDrzewa) {
                this.wysokoscDrzewa = wysokosc-1;
            }
            return;
        }

        this.obliczWysokoscDrzewa(element.getLeft(), wysokosc+1);
        this.obliczWysokoscDrzewa(element.getRight(), wysokosc+1);

    }

        /*
            Metoda wyświetlająca graficznie drzewo
        */

    public void printTree() {
        this.printTree(this.root, 0);
    }

    private void printTree(Element element, int wysokosc) {
        if (element == null) {
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