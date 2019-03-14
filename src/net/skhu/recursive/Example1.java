package net.skhu.recursive;

public class Example1 {

	static void print(int[] a) {
		for (int i : a)
			System.out.printf("%d ", i);
	}

	static void insert(int[] a, int index, int value) {
		//반복 재귀로 해보기
		if(index<=a.length-1) {
			insert(a,index+1,a[index]);
			a[index]=value;
		}
	}

	static void remove(int[] a, int index) {
//		while (index < a.length - 1) {
//			a[index] = a[++index];
//		}
//		a[a.length - 1] = 0;
		if(index<a.length-1) {
			a[index]=a[index+1];
			remove(a,index+1);
		}
		a[a.length-1]=0;
	}

	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < a.length; ++i)
			a[i] = i;


//		insert(a,3,9);
		remove(a,5);
		print(a);

	}

}
