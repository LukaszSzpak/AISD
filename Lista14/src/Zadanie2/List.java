package Zadanie2;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Łukasz Szpak
 */
public class List {
    private ConcurrentLinkedQueue<Node> list;
    private String string;

    /**
     * Klasa umożliwia stworzenie listy wyśpień danej litery w tekscie
     * @param string wyraz do analizy
     */
    public List(String string) {
        this.string = string;
        this.list = new ConcurrentLinkedQueue<>();
    }

    /**
     * Tworzy kolejke priorytetową wierzchołków na podstawie wystąpień danej listery
     */
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

    /**
     * Kolejka wystąpień liter
     * @return
     */
    public ConcurrentLinkedQueue<Node> getList() {
        return this.list;
    }
}
