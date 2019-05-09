public class Tree {

    private Element start;

    public Tree() {
        this.start = null;
    }

    public void add(int key) {

        if(this.start == null) {
            this.start = new Element(key);
            return;
        }

        Element temp = this.start;
        while(temp != null) {

            if(temp.getKey() == key)
                return;

            if(key < temp.getKey()) {

                if(temp.getLeft() == null) {
                    temp.setLeft(new Element(key));
                }

                temp = temp.getLeft();
            } else {
                
                if(temp.getRight() == null) {
                    temp.setRight(new Element(key));
                    return;
                }

                temp = temp.getRight();
            }               
        }
    }
        /*
            Metoda IN-ORDER do wyświetlania drzewa
        */

    public void inOrder() {
        this.inOrder(this.start);
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
        this.preOrder(this.start);
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
        this.postOrder(this.start);
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
            Metoda wyszukiwania najmniejszego elementu drzewa
        */
    
    public int minElement() {
        
        Element temp = this.start;

        while(temp.getLeft() != null) {
            temp = temp.getLeft();
        }

        return temp.getKey();
    }

        /*
            Metoda wyszukiwania największego elementu drzewa
        */

    public int maxElement() {
        Element temp = this.start;

        while(temp.getRight() != null) {
            temp = temp.getRight();
        }

        return temp.getKey();
    }

        /* 
            Metoda wyszukanie klucza w drzewie
        */

    public int findKey(int key) {
        
        Element temp = this.start;
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
}