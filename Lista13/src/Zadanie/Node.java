package Zadanie;

import java.util.ArrayList;

public class Node {
    private int value;
    private boolean isVisited;
    private ArrayList<Node> Nodes;

    public Node(int value) {
        this.value = value;
        this.Nodes = new ArrayList<>();
    }

    public void setVisited(boolean v) {
        this.isVisited = v;
    }

    public void addNode(Node node) {
        this.Nodes.add(node);
    }

    public int getListSize() {
        return this.Nodes.size();
    }

    
    public boolean getIsVisited() {
        return this.isVisited;
    }

    public int getValue() {
        return this.value;
    }

    public Node getNode(int number) {
        return this.Nodes.get(number);
    }

}