package Zadanie2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Graf {
    int numberOfNodes;
    ArrayList<Edge> edgeLists = new ArrayList<>();

    public Graf(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
    }

    public void addEgde(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        edgeLists.add(edge); //add to total edges
    }

    public void kruskal(){
        PriorityQueue<Edge> pq = new PriorityQueue<>(edgeLists.size(), Comparator.comparingInt(o -> o.weight));

        //add all the edges to priority queue, //sort the edges on weights
        for (int i = 0; i <edgeLists.size() ; i++) {
            pq.add(edgeLists.get(i));
        }

        //create a parent []
        int [] parent = new int[numberOfNodes];

        //makeset
        makeSet(parent);

        ArrayList<Edge> mst = new ArrayList<>();

        //process numberOfNodes - 1 edges
        int index = 0;
        while(index<numberOfNodes-1){
            Edge edge = pq.remove();
            //check if adding this edge creates a cycle
            int x_set = find(parent, edge.source);
            int y_set = find(parent, edge.destination);

            if(x_set == y_set){
                //ignore, will create cycle
            }else {
                //add it to our final result
                mst.add(edge);
                index++;
                union(parent,x_set,y_set);
            }

            System.out.println("Wyswietlam aktualny stan listy: ");
            for (Edge temp: mst) {
                System.out.println(temp.toString());
            }
            System.out.println("Koniec listy\n");
        }
        //print
        System.out.println("Minimalne drzewo spinające: ");
        printgraf(mst);
    }

    public void makeSet(int [] parent){
        //Make set- creating a new element with a parent pointer to itself.
        for (int i = 0; i <numberOfNodes ; i++) {
            parent[i] = i;
        }
    }

    public int find(int [] parent, int vertex){
        //chain of parent pointers from x upwards through the tree
        // until an element is reached whose parent is itself
        if(parent[vertex]!=vertex)
            return find(parent, parent[vertex]);;
        return vertex;
    }

    public void union(int [] parent, int x, int y){
        int x_set_parent = find(parent, x);
        int y_set_parent = find(parent, y);
        //make x as parent of y
        parent[y_set_parent] = x_set_parent;
    }

    public void printgraf(ArrayList<Edge> edgeList){
        for (int i = 0; i <edgeList.size() ; i++) {
            Edge edge = edgeList.get(i);
            System.out.println(edge.toString());
        }
    }
}
