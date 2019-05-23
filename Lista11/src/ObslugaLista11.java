public class ObslugaLista11 {

    public static void main(String [] args) {
        Tree BST = new Tree();

        BST.add(15);
        BST.add(5);
        BST.add(54);
        BST.add(32);
        BST.add(1);
        BST.add(8);
        BST.add(3);
        BST.add(9);
        BST.add(21);
        BST.add(82);

        Gui gui = new Gui(BST);
        gui.run();

    }
}