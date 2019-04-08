package net.skhu.recursive;

public class Example3 {

	static class Node {
		int value;
		Node next;

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		public void printAll() {
			System.out.print(this.value + " ");
			if (this.next != null)
				this.next.printAll();
		}

		public void addTail(int value) {
//			if (next != null)
//				next.addTail(value);
//			else
//				next = new Node(value, null);
			Node tmp = this;
			while(tmp.next!= null) {
				tmp= tmp.next;
			}
			tmp.next = new Node(value, null);
		}
	}
		public static void main(String[] args) {
			Node root = new Node(0,null);
			for (int i = 1; i <= 10; ++i)
				root.addTail(i);

			root.printAll();
		}
}
