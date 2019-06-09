package Zadanie2;

/**
 * @author Łukasz Szpak
 */
public class Obsluga2 {

    public  static  void main(String[] args) {
        String word = "ABCDABBBDDBBEEEFFFF";

        List lista = new List(word);
        lista.makeList();

        BST bst = new BST(lista.getList(), word);
        bst.makeTree();
        bst.makeSignValue();

        bst.printTree();

        String code = bst.makeEndString(word);

        System.out.println(code);
        System.out.println(bst.makeString(code));
    }
}
