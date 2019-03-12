package net.skhu.recursive;

public class Example1 {

	static void print(int[] a) {
		for (int i : a)
			System.out.printf("%d ", i);
	}

	static void insert(int[] a, int index, int value) {
		//반복 재귀로 해보기
		int tmp = a.length - 1;
		while (index < tmp) {
			a[tmp] = a[tmp - 1];
			tmp--;
		}
		a[index] = value;
	}

	static void remove(int[] a, int index) {
		while (index < a.length - 1) {
			a[index] = a[++index];
		}
		a[a.length - 1] = 0;

	}

	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < a.length; ++i)
			a[i] = i;

		remove(a, 5);

		print(a);

	}

}
