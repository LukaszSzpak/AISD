package prim;

public class PrimMain {

    public static void main(String[] args) {

        int[][] graf = new int[][]
              { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        int wielkoscGrafu = 5;

        Prim prim = new Prim(wielkoscGrafu, graf);

        prim.prim();
    }
}
