package Zadanie2;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Łukasz Szpak
 */
public class BST {
    private ConcurrentLinkedQueue<Node> nodesList;
    private ConcurrentLinkedQueue<Node> nodesListEnd;
    private Node root;
    private String string;

    /**
     * Klasa umożliwia stworzenie drzewa BST na podstawie kolejki wystąpień liter w tekscie
     * @param list lista wierzchołków
     * @param string słowo w kodzie ASCII
     */
    public BST(ConcurrentLinkedQueue<Node> list, String string) {
        this.nodesList = list;
        this.nodesListEnd = new ConcurrentLinkedQueue<>();
        this.nodesListEnd.addAll(this.nodesList);

        this.root = new Node(0, '?');
        this.string = string;
    }

    /**
     * Tworzy drzewo BST na podstawie liczności danego znaku ASCII
     */
    public void makeTree() {
        if (this.nodesList.isEmpty())
            return;

        if (this.nodesList.size() > 1) {
            this.root = new Node(0, '?');

            Node t1 = this.nodesList.poll();
            Node t2 = this.nodesList.poll();
            this.root.setValue(t2.getValue() + t1.getValue());

            if (t1.compareTo(t2) < 0) {
                this.root.setLeft(t1);
                this.root.setRight(t2);
            } else {
                this.root.setLeft(t2);
                this.root.setRight(t1);
            }

            this.nodesList.add(this.root);

            makeTree();
        }

        if (this.nodesList.size() == 1) {
            this.root = this.nodesList.poll();
            return;
        }
    }

    /**
     * Wyświetl stworzone drzewo metodą IN-ORDER
     */
    public void printTree() {
        this.printTree(this.root);
    }

    private void printTree(Node node) {
        if (node == null)
            return;

        this.printTree(node.getLeft());
        System.out.println(node.toString());
        this.printTree(node.getRight());
    }

    /**
     * Uzupełnia wierzchołki drzewa w kod binarny dla danego znaku
     */
    public void makeSignValue() {
        this.makeSignValue(this.root, "");
    }

    private void makeSignValue(Node node, String string) {
        if (node == null)
            return;
        if(node.getSign() != '?')
            node.setSignValue(string);

        this.makeSignValue(node.getLeft(), string + "0");
        this.makeSignValue(node.getRight(), string + "1");
    }

    /**
     * Tworzy kod binarny ze słowa podanego w parametrze
     * @param string słowo w znakach ASCII
     * @return kod binarny
     */
    public String makeEndString(String string) {
        String endString = "";

        for (int i = 0; i < string.length(); i++) {
            endString += this.findSignCode(string.charAt(i));
        }

        return endString;
    }

    private String findSignCode(char sign) {
        for (Node node: this.nodesListEnd) {
            if(node.getSign() == sign) {
                return node.getSignValue();
            }

        }

        return null;
    }

    /**
     * Tworzy wyraz / zdanie z kody binarnego
     * @param string kod binarny
     * @return wyraz w kodzie ASCII
     */
    public String makeString(String string) {
        String endWord = "";
        String tempWord = null;
        String tempCode = "";

        for (int i = 0; i < string.length();) {
            do {
                tempCode += string.charAt(i);
                tempWord = this.findSign(tempCode);
                i++;

            } while (i < string.length() && tempWord == null);

            tempCode = "";
            endWord += tempWord;
            tempWord = null;
        }

        return endWord;
    }

    private String findSign(String code) {
        for (Node node: this.nodesListEnd) {
            if(node.getSignValue().equals(code)) {
                return node.getSign() + "";
            }

        }

        return null;
    }
}
