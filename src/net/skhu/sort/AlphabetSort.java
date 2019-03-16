package net.skhu.sort;

import java.util.Arrays;

public class AlphabetSort {
	static void selectionSort(char[] a) {
		for (int i = 0; i < a.length - 1; ++i) {
			int minIndex = findMin(a, i); // 배열 a의 i 위치부터 끝까지에서 가장 작은 값을 찾아서
			swap(a, i, minIndex); // 그 값을 i 위치로 이동한다
		}
	}
	static void swap(char[] a, int i,int j) {
		char tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	static int findMin(char[] a,int start) {
		char min = a[start];
		int minIndex = start;
		for (int i = start; i <= a.length - 1; i++) {
			if (min-a[i] > 0) {
				min = a[i];
				minIndex = i;
			}
		}

		return minIndex;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] a = new char[12];
		a[0]='A';
		a[1]='t';
		a[2]='T';
		a[3]='b';
		a[4]='H';
		a[5]='Q';
		a[6]='e';
		a[7]='t';
		a[8]='Y';
		a[9]='q';
		a[10]='z';
		a[11]='e';

		System.out.println(Arrays.toString(a));
		selectionSort(a);
		System.out.println(Arrays.toString(a));
	}

}
