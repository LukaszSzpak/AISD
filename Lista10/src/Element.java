public class Element {

    private Element left;
    private Element right;
    private int key;

    public Element(int key) {
        this.key = key;
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

    //funkcje

    public String toString() {
        return "Klucz: " + this.key;
    }
}