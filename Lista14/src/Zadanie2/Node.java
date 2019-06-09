package Zadanie2;

/**
 * @author Łukasz Szpak
 */

public class Node implements Comparable<Node> {
    private int value;
    private Node left;
    private Node right;
    private char sign;
    private String signValue;

    /**
     * Tworzy wierzchołek drzewa BST
     * @param value ilosc wystapien
     * @param sign  znak ASCII
     */
    public Node(int value, char sign) {
        this.value = value;
        this.sign = sign;
    }

    /**
     * Ilosc wystapien
     * @return ilosc wystąpien w wyrazie
     */
    public int getValue() {
        return value;
    }

    /**
     * Ustawia ilość wystapień
     * @param value ilość wystąpień
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Lewe dziecko
     * @return lewe dziecko
     */
    public Node getLeft() {
        return left;
    }

    /**
     * Ustawia lewe dziecko
     * @param left lewe dziecko
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * Prawe dziecko
     * @return prawe dziecko
     */
    public Node getRight() {
        return right;
    }

    /**
     * Ustawia prawe dziecko
     * @param right prawe dziecko
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * Znak w zapisie ASCII
     * @return znak w zapisie ASCII
     */
    public char getSign() {
        return sign;
    }

    /**
     * Ustawia znak w zapisie ASCII
     * @param sign znak ASCII
     */
    public void setSign(char sign) {
        this.sign = sign;
    }

    /**
     * Kod binarny znaku
     * @return kod binarny
     */
    public String getSignValue() {
        return signValue;
    }

    /**
     * Ustawia kod binarny znaku
     * @param signValue kod binarny
     */
    public void setSignValue(String signValue) {
        this.signValue = signValue;
    }

    /**
     * Zwieksz ilosc wystąpień o 1
     */
    public void increasValue() {
        this.value++;
    }

    /**
     * toString
     * @return
     */
    public  String toString() {
        return "Literka: " + this.sign + " Wartosc kodowa: " + this.signValue + " Ilosc wystapien: " + this.value;
    }

    /**
     *
     * @param o wierzchołek do porównania
     * @return 0 - równe, 1 - wieksze, -1 - mniejsze
     */
    @Override
    public int compareTo(Node o) {
        if (this.getValue() > o.getValue())
            return 1;

        if (this.getValue() < o.getValue())
            return -1;

        return 0;
    }
}
