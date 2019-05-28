public class ObslugaLista12 {

    public static void main(String[] args) {

        ZbiorRozlacznyWezly zbiorWezly = new ZbiorRozlacznyWezly();

        zbiorWezly.makeSet(5);
        zbiorWezly.makeSet(8);
        zbiorWezly.makeSet(12);
        zbiorWezly.makeSet(15);
        zbiorWezly.makeSet(21);
        zbiorWezly.makeSet(58);

        zbiorWezly.union(5, 8);
        zbiorWezly.union(12, 15);
        zbiorWezly.union(8, 21);
        zbiorWezly.union(15, 21);
        zbiorWezly.union(58, 12);

        zbiorWezly.print();

        zbiorWezly.findWithPathCompr(12);
        zbiorWezly.print();
    }
}