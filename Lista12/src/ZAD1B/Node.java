package ZAD1B;

public class Node {
    private Node parent;
    private int value;

	public Node(int value) {
        this.value = value;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getParent() {
        return this.parent;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return this.value + " ";
    }
}