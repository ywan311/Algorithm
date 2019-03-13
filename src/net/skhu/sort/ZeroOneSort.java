package net.skhu.sort;

import java.util.Random;

public class ZeroOneSort {//0과 1로만 이루어진 배열의 정렬
	static int[] sort(int[] a) {
		int cnt=0;
		for(int i=0;i<=a.length-1;i++) {
			if(a[i]==0)
				cnt++;
		}
		for(int i=0;i<=a.length-1;i++) {
			if(cnt>0) {
				a[i]=0;
				cnt--;
			}else
				a[i]=1;
		}

		return a;
	}
	static void print(int[] a) {
		for (int i : a)
			System.out.printf("%d ", i);
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int[] array = new int[20];
		for(int i=0;i<=array.length-1;i++) {
			array[i]= random.nextInt(2);
		}
		print(array);
		sort(array);
		print(array);


	}

}
