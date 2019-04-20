package net.skhu.redblack;

import java.util.List;

public class Node {
    static final char RED = 'R';
    static final char BLACK = 'B';
    static final char BLACK_MINUS = 'b'; // 삭제 후 경로에서 블랙 노드가 1개 부족한 노드 표시
    static final Node NULL;              // null 노드

    static { // static constructor
        NULL = new Node(0);
        NULL.color = BLACK;
        NULL.left = NULL.right = NULL;
    }

    int value;
    Node left, right;
    char color;

    public Node(int value) {
        this.value = value;
        this.color = RED;
        this.left = this.right = NULL;
    }

    public static boolean isRed(Node n) {
        return n.color == RED;
    }

    public static boolean isBlack(Node n) {
        return n.color == BLACK || n.color == BLACK_MINUS;
    }

    public static Node add(Node n, int value) {
        if (n == NULL) return new Node(value);
        if (value < n.value) {
            n.left = add(n.left, value);
            n = afterAddLeft(n); // 왼쪽에 삽입 후 재조정
        } else if (value > n.value) {
            n.right = add(n.right, value);
            n = afterAddRight(n); // 오른쪽에 삽입 후 재조정
        }
        return n;
    }

    private static Node afterAddLeft(Node n) { // 왼쪽에 삽입 후 재조정
        if (isRed(n.left) && isRed(n.left.left)) {
            if (isRed(n.right)) { // (C-1)
                n.color = RED;
                n.left.color = n.right.color = BLACK;
            } else {              // (C-2)
                n = rotateRight(n);
                n.color = BLACK;
                n.right.color = RED;
            }
        } else if (isRed(n.left) && isRed(n.left.right)) { // (C-3a) (C-3b)
            n.left = rotateLeft(n.left);
            n = afterAddLeft(n); // (C-1), (C-2) 규칙을 적용하기 위한 재귀 호출
        }
        return n;
    }

    private static Node afterAddRight(Node n) { // 오른쪽에 삽입 후 재조정
        if (isRed(n.right) && isRed(n.right.right)) {
            if (isRed(n.left)) {  // (C-1)
                n.color = RED;
                n.right.color = n.left.color = BLACK;
            } else {              // (C-2)
                n = rotateLeft(n);
                n.color = BLACK;
                n.left.color = RED;
            }
        } else if (isRed(n.right) && isRed(n.right.left)) { // (C-3a) (C-3b)
            n.right = rotateRight(n.right);
            n = afterAddRight(n); // (C-1), (C-2) 규칙을 적용하기 위한 재귀 호출
        }
        return n;
    }

    private static Node rotateRight(Node n) {
        Node m = n.left;
        n.left = m.right;
        m.right = n;
        return m;
    }

    private static Node rotateLeft(Node n) {
        Node m = n.right;
        n.right = m.left;
        m.left = n;
        return m;
    }

    public static int getLeftMostValue(Node n) {
        if (n.left == NULL) return n.value;
        return getLeftMostValue(n.left);
    }

    public static Node remove(Node n, int value) {
        if (n == NULL) return n;
        if (value < n.value) {
            n.left = remove(n.left, value);
            n = afterRemoveLeft(n); // 왼쪽에서 삭제 후 재조정
        } else if (value > n.value) {
            n.right = remove(n.right, value);
            n = afterRemoveRight(n); // 오른쪽에서 삭제 후 재조정
        } else {
            if (n.left != NULL && n.right != NULL) {
                n.value = getLeftMostValue(n.right);
                n.right = remove(n.right, n.value);
                n = afterRemoveRight(n); // 오른쪽에서 삭제 후 재조정
            } else {
                Node child = (n.left != NULL) ? n.left : n.right;
                if (n.color == 'B' && child.color == 'B')
                    child.color = BLACK_MINUS; // 경로에서 블랙 노드 한 개 부족
                else child.color = BLACK;
                n = child;
            }
        }
        return n;
    }

    private static Node afterRemoveLeft(Node n) {  // 왼쪽에서 삭제 후 재조정
        if (n.left.color != BLACK_MINUS) return n;
        n.left.color = BLACK;
        Node s = n.right, c1 = n.right.left, c2 = n.right.right;
        if (isBlack(s) && isBlack(c1) && isBlack(c2)) {      // (Case 1-1 2-1)
            s.color = RED;                                   // (Case 1-1 2-1)
            if (isBlack(n)) n.color = BLACK_MINUS;           // (Case 2-1)
            else n.color = BLACK;                            // (Case 1-1)
        } else if (isBlack(s) && isRed(c2)) {                // (Case 1-2a 1-2b 2-2a 2-2b)
            n = rotateLeft(n);                               // (Case 1-2a 1-2b 2-2a 2-2b)
            if (isRed(n.left)) n.color = RED;                // (Case 1-2a 1-2b)
            n.left.color = n.right.color = BLACK;            // (Case 1-2a 1-2b 2-2a 2-2b)
        } else if (isBlack(s) && isRed(c1) && isBlack(c2)) { // (Case 1-3 2-3)
            Node temp = c1.right;                            // (Case 1-3 2-3)
            c1.right = s;                                    // (Case 1-3 2-3)
            s.left = temp;                                   // (Case 1-3 2-3)
            n.right = c1;                                    // (Case 1-3 2-3)
            n = rotateLeft(n);                               // (Case 1-3 2-3)
            if (isRed(n.left)) n.left.color = BLACK;         // (Case 1-3)
            else n.color = BLACK;                            // (Case 2-3)
        } else if (isRed(s) && isBlack(c1) && isBlack(c2)) { // (Case 2-4)
            n = rotateLeft(n);
            n.color = BLACK;
            n.left.color = RED;
            n.left.left.color = BLACK_MINUS;
            n.left = afterRemoveLeft(n.left); // 트리 재조정 재귀 호출
        }
        return n;
    }

    private static Node afterRemoveRight(Node n) { // 오른쪽에서 삭제 후 재조정
        if (n.right.color != BLACK_MINUS) return n;
        n.right.color = BLACK;
        Node s = n.left, c1 = n.left.right, c2 = n.left.left;
        if (isBlack(s) && isBlack(c1) && isBlack(c2)) {      // (Case 1-1 2-1)
            s.color = RED;                                   // (Case 1-1 2-1)
            if (isBlack(n)) n.color = BLACK_MINUS;           // (Case 2-1)
            else n.color = BLACK;                            // (Case 1-1)
        } else if (isBlack(s) && isRed(c2)) {                // (Case 1-2a 1-2b 2-2a 2-2b)
            n = rotateRight(n);                              // (Case 1-2a 1-2b 2-2a 2-2b)
            if (isRed(n.right)) n.color = RED;               // (Case 1-2a 1-2b)
            n.right.color = n.left.color = BLACK;            // (Case 1-2a 1-2b 2-2a 2-2b)
        } else if (isBlack(s) && isRed(c1) && isBlack(c2)) { // (Case 1-3 2-3)
            Node temp = c1.left;                             // (Case 1-3 2-3)
            c1.left = s;                                     // (Case 1-3 2-3)
            s.right = temp;                                  // (Case 1-3 2-3)
            n.left = c1;                                     // (Case 1-3 2-3)
            n = rotateRight(n);                              // (Case 1-3 2-3)
            if (isRed(n.right)) n.right.color = BLACK;       // (Case 1-3)
            else n.color = BLACK;                            // (Case 2-3)
        } else if (isRed(s) && isBlack(c1) && isBlack(c2)) { // (Case 2-4)
            n = rotateRight(n);
            n.color = BLACK;
            n.right.color = RED;
            n.right.right.color = BLACK_MINUS;
            n.right = afterRemoveRight(n.right); // 트리 재조정 재귀 호출
        }
        return n;
    }

    public static boolean contains(Node n, int value) {
        if (n == NULL) return false;
        if (value < n.value) return contains(n.left, value);
        else if (value > n.value) return contains(n.right, value);
        return true;
    }

    public static void print(Node n) {
        if (n == NULL) return;
        print(n.left);
        System.out.printf("%d%c ", n.value, n.color);
        print(n.right);
    }

   public static void toList(Node n, List<Integer> list) {
        if (n == NULL) return;
        toList(n.left, list);
        list.add(n.value);
        toList(n.right, list);
    }
}
