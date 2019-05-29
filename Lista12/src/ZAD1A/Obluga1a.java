package ZAD1A;

public class Obluga1a {

    public static void main(String[] args) {
        
        ZbiorRozlacznyTablica zbior = new ZbiorRozlacznyTablica(100);

        zbior.insert(4);
        zbior.insert(3);
        zbior.insert(21);
        zbior.insert(85);
        zbior.insert(52);
        zbior.insert(42);

        zbior.union(3, 4);
        zbior.union(4, 52);
        zbior.union(21, 85);
        zbior.union(42, 3);

        zbior.print();

        zbior.find(42);
        zbior.print();
    }
}