public class Element {

    private Element left;
    private Element right;
    private Element parent;
    private int key;
    private boolean color;

        /*
            zmienna color => false - czerwone / true - czarne
        */

    public Element(int key) {
        this.key = key;
        this.color = false;
    }

    public Element(Element element) {
        this.left = element.left;
        this.right = element.right;
        this.key = element.key;
    }

    //get'ery

    public Element getLeft() {
        return this.left;
    }

    public Element getRight() {
        return this.right;
    }

    public int getKey() {
        return this.key;
    }

    public Element getParent() {
        return this.parent;
    }

    public boolean getColor() {
        return this.color;
    }

    //set'ery

    public void setLeft(Element left) {
        this.left = left;
    }

    public void setRight(Element right) {
        this.right = right;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setParent(Element element) {
        this.parent = element;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    //funkcje

    public String toString() {
        return this.key + "-" + (String)(this.color? "(B)": "(R)");
    }
}