package net.skhu.binaryTree.viewer;

public class BinaryTree {
    Node root = null;

    public void add(int value) {
        root = Node.add(root, value);
    }

    public void remove(int value) {
        root = Node.remove(root, value);
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public static Node add(Node n, int value) {
        if (n == null) return new Node(value);
        if (value < n.value)
            n.left = add(n.left, value);
        else if (value > n.value)
            n.right = add(n.right, value);
        return n;
    }

    public static int getLeftMostValue(Node n) {
        if (n.left == null)
            return n.value;
        return getLeftMostValue(n.left);
    }

    public static Node remove(Node n, int value) {
        if (n == null)
            return null;
        if (value < n.value)
            n.left = remove(n.left, value);
        else if (value > n.value)
            n.right = remove(n.right, value);
        else {
            if (n.left != null && n.right != null) {
                int temp = getLeftMostValue(n.right);
                n.value = temp;
                n.right = remove(n.right, temp);
            } else
                return (n.left != null) ? n.left : n.right;
        }
        return n;
    }
}
