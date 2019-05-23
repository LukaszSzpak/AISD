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

    public void findWithCompr(int value) {
        Node temp = this.find(value);
        Node parent = temp;

        while(parent.getParent() != null) {
            parent = parent.getParent();
        }

        temp.setParent(parent);
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