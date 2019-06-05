package Zadanie;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Graf {
    private ArrayList<Node> NodeList;
    private Queue<Node> NodeQu;

    public Graf() {
        this.NodeList = new ArrayList<>();
        this.NodeQu = new ConcurrentLinkedQueue<>();
    }

    public void add(int value) {
        this.NodeList.add(new Node(value));
    }

    public Node findNode(int value) {
        for (int i = 0; i < this.NodeList.size(); i++) {
            Node temp = this.NodeList.get(i);

            if(temp.getValue() == value)
                return temp;
        }

        throw new NoSuchElementException();
    }

    public void link(int val1, int val2) {
        Node node1 = this.findNode(val1);
        Node node2 = this.findNode(val2);

        node1.addNode(node2);
        node2.addNode(node1);
    }

    public void print() {

        for (int i = 0; i < this.NodeList.size(); i++) {

            Node temp = this.NodeList.get(i);
            System.out.print(temp.getValue() + ": ");

            for (int j = 0; j < temp.getListSize(); j++) {
                System.out.print(temp.getNode(j).getValue() + " ");
            }

            System.out.println();
        }
    }

    public void BFS(int value) {
        Node node = this.findNode(value);

        System.out.println("Wyswietlam BFS:");

        this.NodeQu.clear();

        this.BFS(node);

        for(Node temp: this.NodeQu) {
            System.out.println(temp.getValue());
        }
    }

    private void BFS(Node node) {

        if(!this.NodeQu.contains(node)) {
            this.NodeQu.add(node);
        }

        for (int i = 0; i < node.getListSize(); i++) {
            Node temp = node.getNode(i);

            if(!this.NodeQu.contains(temp)) {
                this.BFS(temp);
            }
        }
    }
}