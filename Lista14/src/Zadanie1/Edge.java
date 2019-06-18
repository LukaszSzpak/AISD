package Zadanie1;

public class Edge {

    int source;
    int destination;
    int weight;
    Edge prevEdge;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String toString() {
        return "Krawedz: wierzchołki " + this.source + " -> " + this.destination + " waga: " + this.weight;
    }

    public Edge getPrevEdge() {
        return prevEdge;
    }

    public void setPrevEdge(Edge prevEdge) {
        this.prevEdge = prevEdge;
    }
}
