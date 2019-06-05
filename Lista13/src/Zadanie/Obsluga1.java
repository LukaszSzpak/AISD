package Zadanie;

public class Obsluga1 {

    public static void main(String[] args) {

        Graf graf = new Graf();

        graf.add(5);
        graf.add(12);
        graf.add(25);
        graf.add(65);
        graf.add(8);
        graf.add(7);

        graf.link(5, 12);
        graf.link(12, 25);
        graf.link(65, 8);
        graf.link(65, 12);
        graf.link(5, 7);

        graf.print();
        graf.BFS(12);
        graf.DFS(12);
    }
}