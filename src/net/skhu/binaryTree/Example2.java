package net.skhu.binaryTree;

public class Example2 {

	static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public void add(int value) {
			if (value < this.value) {
				if (left == null)
					left = new Node(value);
				else
					left.add(value);
			} else if (value > this.value) {
				if (right == null)
					right = new Node(value);
				else
					right.add(value);
			} // (value == this.value)인 경우 add 하지 않고 무시한다;
		}

		public void print() {
			if (left != null)
				left.print();
			System.out.printf("%d ", value);
			if (right != null)
				right.print();
		}

		public boolean contains(int value) {
			if (value < this.value)
				return left != null && left.contains(value);
			else if (value > this.value)
				return right != null && right.contains(value);
			return true; // (value == this.value)인 경우 return true;
		}

		public int getLeftMostValue() {
			if (this.left != null)
				return this.left.getLeftMostValue();
			return this.value;
		}
		public int getRightMostValue() {
			if(this.right !=null)
				return this.right.getRightMostValue();
			return this.value;
		}
        public void remove(int value, Node parent) {
            if (value < this.value) {
                if (left != null) left.remove(value, this);
            } else if (value > this.value) {
                if (right != null) right.remove(value, this);
            } else {
                if (left != null && right != null) {
                    int temp = right.getLeftMostValue(); // this.value 다음으로 큰 값
                    this.value = temp;
                    right.remove(temp, this);
                } else {
                    Node child = (left != null) ? left : right;
                    if (parent.left == this) parent.left = child;
                    else parent.right = child;
                }
            }
        }

	}
	static class BinaryTree {
        Node dummy;

        public BinaryTree() {
            dummy = new Node(Integer.MAX_VALUE);
        }

        public void add(int value) {
            dummy.add(value);
        }

        public void print() {
            if (dummy.left != null) dummy.left.print();
            System.out.println();
        }

        public boolean contains(int value) {
            return dummy.left != null && dummy.left.contains(value);
        }

        public void remove(int value) {
            if (dummy.left != null)
                dummy.left.remove(value, dummy);
        }
    }



	public static void main(String[] args) {
		int[] a = { 5, 18, 1, 12, 7, 2, 14, 6, 9, 15 };
		Node root = new Node(10);
		for (int i = 0; i < a.length; ++i)
			root.add(a[i]);

		root.print();
		root.remove(10,root);
		root.print();
		System.out.println();
	}
}
