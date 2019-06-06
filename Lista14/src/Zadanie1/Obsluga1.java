package Zadanie1;

public class Obsluga1 {

    public static void main(String[] args) {
        int vertices = 6;
        Graf graf = new Graf(vertices);
        graf.addEdge(0, 1, 4);
        graf.addEdge(0, 2, 3);
        graf.addEdge(1, 2, 1);
        graf.addEdge(1, 3, 2);
        graf.addEdge(2, 3, 4);
        graf.addEdge(3, 4, 2);
        graf.addEdge(4, 5, 6);
        graf.dijkstra(0, 4);
    }
}
