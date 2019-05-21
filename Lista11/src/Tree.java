public class Tree {

    private Element root;
    private Element parent;
    private Element sentinel;
    private int iloscLisci;
    private int iloscWezlow;
    private int wysokoscDrzewa;

    public Tree() {
        this.root = null;
        this.sentinel = new Element(0);
    }

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

        newEl.setColor(false);
        newEl.setLeft(this.sentinel);
        newEl.setRight(this.sentinel);

        this.balanceAfterInsert(newEl);
    }

 
    private void balanceAfterInsert(Element begin) {
        Element node = begin;
        Element parent = node.getParent();

        if (parent == null) {
            // Case 1 - The current node is at the root of the tree.
            System.out.println("gdzie ty kurwo 1");
            node.setColor(true);
            return;

            
        }

        

        if (parent.getColor()) {
            // Case 2 - The current node's parent is black, so property 4 (both
            // children of every red node are black) is not invalidated.
            System.out.println("gdzie ty kurwo 2");
            return;
        }

        Element grandParent = node.getGrandParent();
        Element uncle = node.getUncle(grandParent);

        if(uncle == null)
            System.out.println("Jestem pustym wujkiem");

        if (!parent.getColor() 
        && uncle.getColor()) {
            System.out.println("gdzie ty kurwo 3");
            // Case 3 - If both the parent and the uncle are red, then both of
            // them can be repainted black and the grandparent becomes
            // red (to maintain property 5 (all paths from any given node to its
            // leaf nodes contain the same number of black nodes)).
            parent.setColor(true);
            uncle.setColor(true);
            if (grandParent != null) {
                grandParent.setColor(false);
                balanceAfterInsert(grandParent);
            }
            return;
        }

        if (!parent.getColor() && uncle.getColor()) {
            System.out.println("gdzie ty kurwo 4");
            // Case 4 - The parent is red but the uncle is black; also, the
            // current node is the right child of parent, and parent in turn
            // is the left child of its parent grandparent.
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

        if (!parent.getColor() && uncle.getColor()){
            // Case 5 - The parent is red but the uncle is black, the
            // current node is the left child of parent, and parent is the
            // left child of its parent G.
            System.out.println("gdzie ty kurwo 5");
            parent.setColor(true);
            grandParent.setColor(false);
            if (node == parent.getLeft() && parent == grandParent.getLeft()){
                // left-left
                rotateRight(grandParent);
            } else if (node == parent.getRight() && parent == grandParent.getRight()) {
                // right-right
                rotateLeft(grandParent);
            }
        }
    }

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