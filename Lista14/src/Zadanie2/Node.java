package Zadanie2;

public class Node implements Comparable<Node> {
    private int value;
    private Node left;
    private Node right;
    private char sign;
    private String signValue;

    public Node(int value, char sign) {
        this.value = value;
        this.sign = sign;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public String getSignValue() {
        return signValue;
    }

    public void setSignValue(String signValue) {
        this.signValue = signValue;
    }

    public void increasValue() {
        this.value++;
    }

    public  String toString() {
        return "Literka: " + this.sign + " Wartosc kodowa: " + this.signValue + " Ilosc wystapien: " + this.value;
    }

    @Override
    public int compareTo(Node o) {
        if (this.getValue() > o.getValue())
            return 1;

        if (this.getValue() < o.getValue())
            return -1;

        return 0;
    }
}
