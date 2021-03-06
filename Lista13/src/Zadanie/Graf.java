package Zadanie;

import java.util.ArrayList;
import java.util.Iterator;
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

        /*
            Algorytm wyswietlania listy sąsiedztwa
         */

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
        /*
            Algorytm przeszukiwania grafu wszerz
         */

    public void BFS(int value) {
        System.out.println("\nWyswietlam BFS:");

        this.NodeQu.clear();

        for (int i = 0; i < this.NodeList.size(); i++) {
            this.NodeList.get(i).setVisited(false);
        }

        this.BFS(this.findNode(value));

    }

    private void BFS(Node node) {

        this.NodeQu.add(node);
        node.setVisited(true);

        while(!this.NodeQu.isEmpty()) {
            Node temp = this.NodeQu.peek();

            for (int i = 0; i < temp.getListSize(); i++) {
                if (temp.getNode(i).getIsVisited() == false) {
                    this.NodeQu.add(temp.getNode(i));
                    temp.getNode(i).setVisited(true);
                }
            }

            System.out.println("Stan kolejki:");
            Iterator<Node> it = this.NodeQu.iterator();
            while (it.hasNext())
                System.out.println(it.next().toString());
            System.out.println("Koniec kolejki");

            System.out.println(this.NodeQu.peek().toString());
            this.NodeQu.poll();
        }
    }

        /*
            Algorytm przeszukiwnia grafu wgłąb
         */

    public void DFS(int value) {
        System.out.println("\nWyswietlam DFS: ");

        for (int i = 0; i < this.NodeList.size(); i++) {
            this.NodeList.get(i).setVisited(false);
        }

        this.DFS(this.findNode(value));
    }

    private void DFS(Node node) {

        System.out.println(node.toString());
        node.setVisited(true);

        for (int i = 0; i < node.getListSize(); i++) {
            if (node.getNode(i).getIsVisited() == false) {
                this.DFS(node.getNode(i));
            }
        }

    }

}