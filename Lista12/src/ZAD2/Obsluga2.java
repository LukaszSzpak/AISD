package ZAD2;

public class Obsluga2 {

    public static void main(String[] args) {
        
        GrafNieskierowany grafNieskierowany = new GrafNieskierowany(10);
        grafNieskierowany.link(2, 3);
        grafNieskierowany.link(8, 6);
        grafNieskierowany.link(6, 5);
        grafNieskierowany.link(3, 4);
        grafNieskierowany.print();
        grafNieskierowany.printList();

        GrafSkierowany grafSkierowany = new GrafSkierowany(10);
        grafSkierowany.link(2, 3);
        grafSkierowany.link(8, 6);
        grafSkierowany.link(6, 5);
        grafSkierowany.link(3, 4);
        grafSkierowany.print();
        grafSkierowany.printList();
    }
}