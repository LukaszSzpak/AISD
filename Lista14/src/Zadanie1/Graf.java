package Zadanie1;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graf {
    private int vertices;
    private LinkedList<Edge>[] adjacencylist;
    private ArrayList<Integer> list;
    private int [] parent;

        /*
            Utworzenie list potrzebnych do przechowywania grafu
         */

    public Graf(int vertices) {
        this.vertices = vertices;
        adjacencylist = new LinkedList[vertices];
        this.list = new ArrayList<>();
        this.parent = new int[vertices];

        for (int i = 0; i <vertices ; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }

        /*
            Metoda do dodawania krawedzi do grafu
         */

    public void addEdge(int source, int destination, int weight) {

        // połączenie w jedna strone
        Edge edge = new Edge(source, destination, weight);
        adjacencylist[source].addFirst(edge);

        // połączenie w druga strone
        edge = new Edge(destination, source, weight);
        adjacencylist[destination].addFirst(edge);
    }

        /*
            Metoda tworzaca odelglosci miedzy poczatkowym a wszytskimi wierzchołkami
         */

    public void dijkstra(int sourceVertex, int endDestination){

        boolean[] SPT = new boolean[vertices];
        int [] distance = new int[vertices];

        this.list.clear();

        // ustawienie odleglosci na najwieksza mozliwa
        for (int i = 0; i <vertices ; i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        // kolejka do przechowywania par
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(vertices, new Comp());

        // pierwszy ma zawsze 0 odległości
        distance[sourceVertex] = 0;
        Pair<Integer, Integer> p0 = new Pair<>(distance[sourceVertex],sourceVertex);
        pq.offer(p0);

        while(!pq.isEmpty()){
            Pair<Integer, Integer> extractedPair = pq.poll();

            /*
            System.out.println("\nWyswietlam aktualna liste odleglosci:");
            for (int i = 0; i < distance.length; i++) {
                System.out.println("Od wierzchołka: " + i + " dlugosc: " + distance[i]);
            }
            */

            int extractedVertex = extractedPair.getValue();
            if(!SPT[extractedVertex]) {
                SPT[extractedVertex] = true;

                LinkedList<Edge> list = adjacencylist[extractedVertex];

                for (int i = 0; i < list.size(); i++) {

                    Edge edge = list.get(i);
                    int destination = edge.destination;

                    if (SPT[destination] == false) {

                        int newKey =  distance[extractedVertex] + edge.weight ;
                        int currentKey = distance[destination];
                        if(currentKey>newKey){
                            Pair<Integer, Integer> p = new Pair<>(newKey, destination);
                            pq.offer(p);
                            distance[destination] = newKey;
                            this.parent[destination] = extractedVertex;

                        }
                    }
                }
            }
        }

        print(distance, sourceVertex, endDestination);
    }

    public void print(int[] distance, int sourceVertex, int endDestination){

        System.out.println("\nDlugosc ścieżki Dijkstra: ");
        System.out.println("Początek: " + sourceVertex + " Koniec: " + endDestination +
                " Waga: " + distance[endDestination]);

        System.out.println("Droga: ");

        int next = endDestination;
        while (next != -1) {
            System.out.println(next);
            next = parent[next];
        }
    }


}