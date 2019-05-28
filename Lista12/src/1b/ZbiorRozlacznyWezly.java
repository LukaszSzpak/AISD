import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ZbiorRozlacznyWezly {

    private ArrayList<Node> list;

    public ZbiorRozlacznyWezly() {
        this.list = new ArrayList<>();
    }

    public void makeSet(int value) {
        this.list.add(new Node(value));
    }

    public Node find(int value) throws NoSuchElementException {
        Node temp = null;

        for(int i = 0; i < list.size(); i++) {
            temp = list.get(i);

            while(temp != null) {
                if (temp.getValue() == value) {
                    while(temp.getParent() != null)
                        temp = temp.getParent();

                    return temp;
                }       
                temp = temp.getParent();
            }
            
        }

            throw new NoSuchElementException();
    }

    public void findWithPathCompr(int value) throws NoSuchElementException {
        Node temp = null;

        for (int i = 0; i < this.list.size(); i++) {
            temp = list.get(i);

            while(temp.getParent() != null && temp.getValue() != value) {
                temp = temp.getParent();
            }

            if(temp.getValue() == value)
                    break;
        }
        
        if (temp != null && temp.getValue() != value)
            throw new NoSuchElementException();

        Node parent = temp;

        while(parent.getParent() != null) {
            parent = parent.getParent();
        }

        if(temp.getParent() != null && temp.getParent() != parent) {
            this.list.add(temp.getParent());
        }

       // Node temp2 = temp;

      /*  while(temp2.getParent() != null) {
            if(temp2.getParent().getParent() != null) {
                Node temp3 = temp2.getParent();
                temp2.setParent(parent);
                this.list.add(temp2);
                temp2 = temp3;
            } else {
                temp2 = temp2.getParent();
            }
        } */

        temp.setParent(parent);
/*
        if (this.list.contains(temp)) {
            this.list.remove(temp);
        }
*/
    }

    public boolean union(int val1, int val2) {
        Node node2 = this.find(val1);
        Node node1 = this.find(val2);

        if(node1 == null || node2 == null) {
            return false;
        }

        node2.setParent(node1);
        //System.out.println(node1.getParent().toString());

        list.remove(node1);

        return true;
    }

    public void print() {
        System.out.println("\nZaczynam wyswietlac drzewo:");

        for(int i = 0; i < list.size(); i++) {

            System.out.println("\nKolejna ścieżka: ");
            Node temp = list.get(i);

            while(temp != null) {
                System.out.println(temp.toString());
                temp = temp.getParent();
            }
            
        }
    }
}