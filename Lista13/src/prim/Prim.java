package prim;

public class Prim {
    private int size;
    private int[][] graf;

    public Prim(int size, int [][] graf) {
        this.size = size;
        this.graf = graf;
    }

    private void printPrim(int[] parent) {
        System.out.println("Pozostałe krawędzie: ");
        for (int i = 1; i < this.size; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graf[i][parent[i]]);
    }


    public void prim() {
        int[] parent = new int[this.size];
        int[] key = new int[this.size];
        boolean[] mstSet = new boolean[this.size];

        for (int i = 0; i < this.size; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < this.size - 1; count++) {
            int u = MinWaga(key, mstSet);
            System.out.println("Wierzechołek który rozpatrujemy: "+u);
            mstSet[u] = true;

            for (int v = 0; v < this.size; v++)
                if (graf[u][v] != 0 && mstSet[v] == false && graf[u][v] < key[v]) {
                    System.out.println("Połączony z: " +v);
                    parent[v] = u;
                    key[v] = graf[u][v];
                }
        }

        this.printPrim(parent);
    }

    private int MinWaga(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int i = 0; i < this.size; i++) {
            if (mstSet[i] == false && key[i] < min) {
                min = key[i];
                min_index = i;
            }
        }

        return min_index;
    }
}
