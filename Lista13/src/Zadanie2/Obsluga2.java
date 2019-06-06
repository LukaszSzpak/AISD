package Zadanie2;

public class Obsluga2 {
    public static void main(String[] args) {
        int numberOfNodes = 6;
        Graf graf = new Graf(numberOfNodes);
        graf.addEgde(0, 1, 4);
        graf.addEgde(0, 2, 3);
        graf.addEgde(1, 2, 1);
        graf.addEgde(1, 3, 2);
        graf.addEgde(2, 3, 4);
        graf.addEgde(3, 4, 2);
        graf.addEgde(4, 5, 6);

        graf.kruskal();
    }
}
