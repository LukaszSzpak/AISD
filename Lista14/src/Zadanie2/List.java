package Zadanie2;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class List {
    private ConcurrentLinkedQueue<Node> list;
    private String string;

    public List(String string) {
        this.string = string;
        this.list = new ConcurrentLinkedQueue<>();
    }

    public void makeList() {
        for (int i = 0; i < string.length(); i++) {
            Iterator<Node> it = this.list.iterator();
            boolean flag = false;

            while(it.hasNext() && !flag) {
                Node temp = it.next();
                char ch = temp.getSign();

                if (this.string.charAt(i) == ch) {
                    flag = true;
                    temp.increasValue();
                }
            }

            if (!flag) {
                this.list.add(new Node(1, this.string.charAt(i)));
            }

        }
    }

    public ConcurrentLinkedQueue<Node> getList() {
        return this.list;
    }
}
