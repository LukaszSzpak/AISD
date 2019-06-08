package Zadanie2;

public class Obsluga2 {

    public  static  void main(String[] args) {

        List lista = new List("ABCDABBBBB");
        lista.makeList();

        BST bst = new BST(lista.getList());
        bst.makeTree();
        bst.makeSignValue();

        bst.printTree();

    }
}
