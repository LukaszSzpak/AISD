package Zadanie2;

import java.util.concurrent.ConcurrentLinkedQueue;

public class BST {
    private ConcurrentLinkedQueue<Node> nodesList;
    private Node root;

    public BST(ConcurrentLinkedQueue<Node> list) {
        this.nodesList = list;
        this.root = new Node(0, '?');
    }

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
}
