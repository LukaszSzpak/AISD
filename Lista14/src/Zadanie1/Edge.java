package Zadanie1;

public class Edge {

    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String toString() {
        return "Krawedz: wierzchołki " + this.source + " -> " + this.destination + " waga: " + this.weight;
    }
}
