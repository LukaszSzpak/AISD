import java.awt.Container;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;

public class Look {

    public Look(Element root) {
        this.root = root;
    }

    private Element root;

    public Container Draw() {
        Container DrawnTree = new Container();
        DrawnTree.setLayout(new GridLayout(12,1));
        Element Sentinel = new Element(0);

        Queue<Element> Queue = new LinkedList<>();

        if (this.root == null)
            return null;

        Queue.add(this.root);

        int nodesInLine = 1;
        int nodesInCurrLine = 1;
        int nodesInNextLine = 0;
        while (nodesInCurrLine > 0) {
            Container Line = new Container();
            Line.setLayout(new GridLayout(1, nodesInLine));

            for (int i = 0; i < nodesInLine; i++) {
                Element currNode = Queue.poll();

                if (currNode == Sentinel) {
                    Line.add(new JButton());
                    Queue.add(Sentinel);
                    Queue.add(Sentinel);
                } else {
                    Line.add(new JButton(currNode.getKey() + ""));

                    if (currNode.getLeft() != null) {
                        Queue.add(currNode.getLeft());
                        nodesInNextLine++;
                    } else {
                        Queue.add(Sentinel);
                    }

                    if (currNode.getRight() != null) {
                        Queue.add(currNode.getRight());
                        nodesInNextLine++;
                    } else {
                        Queue.add(Sentinel);
                    }
                }
            }

            DrawnTree.add(Line);
            nodesInLine*=2;
            nodesInCurrLine = nodesInNextLine;
            nodesInNextLine = 0;
        }

        return DrawnTree;
    }
}