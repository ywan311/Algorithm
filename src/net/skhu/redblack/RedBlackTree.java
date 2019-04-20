package net.skhu.redblack;

import java.util.ArrayList;
import java.util.List;

public class RedBlackTree {
    Node root = Node.NULL;

    public void add(int value) {
        root = Node.add(root, value);
        if (root.color != Node.BLACK) root.color = Node.BLACK;
    }

    public void print() {
        Node.print(root);
    }

    public boolean contains(int value) {
        return Node.contains(root, value);
    }

    public void remove(int value) {
        root = Node.remove(root, value);
        if (root.color != Node.BLACK) root.color = Node.BLACK;
    }

    public List<Integer> toList() {
        List<Integer> list = new ArrayList<Integer>();
        Node.toList(root, list);
        return list;
    }
}
