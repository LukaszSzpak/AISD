package ZAD2;

public class GrafNieskierowany {
    private int[][] tab;

    public GrafNieskierowany(int wielkosc) {
        this.tab = new int[wielkosc][wielkosc];
    }

    public void add(int val) {
        this.tab[val][val] = 1;
    }

    public void link(int val1, int val2) {
        this.tab[val1][val2] = 1;
        this.tab[val2][val1] = 1;   
    }

    public void print() {
        System.out.println("Wyswietlam macierz grafu nieskierowanego: ");
        for(int i = 0; i < this.tab.length; i++) {
            for (int j = 0; j < this.tab.length; j++) {
                System.out.print(this.tab[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printList() {
        System.out.println("\nWyswietlam liste grafu nieskierowanego: ");
        for(int i = 0; i < this.tab.length; i++) {

            int is = 0;

            for (int j = 0; j < this.tab.length; j++)
                is += this.tab[i][j];

            if (is != 0) {
                System.out.print(i + ": ");
                for (int j = 0; j < this.tab.length; j++) {
                        if (this.tab[i][j] != 0) {
                            System.out.print(j + " ");
                        }
                }
                System.out.println();
            }
            
        }
    }
}