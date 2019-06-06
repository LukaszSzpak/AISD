package Zadanie2;

public class Edge {
    protected int source;
    protected int destination;
    protected int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String toString() {
        return "Krawedź: wierzchołki: " + this.source + " -> " + this.destination +  " waga: " + this.weight;
    }
}