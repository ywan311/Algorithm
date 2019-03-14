package net.skhu.sort;

import java.util.Arrays;

public class StringSort {

	static void swap(String[] a, int i, int j) {
		String tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;

	}

	static int findMin(String[] a, int start) {
		String min = a[start];
		int minIndex = start;
		for (int i = start; i < a.length - 1; i++) {
			if (min.compareTo(a[i]) > 0) {
				min = a[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	static void selectionSort(String[] a) {
		for (int i = 0; i < a.length - 1; ++i) {
			int minIndex = findMin(a, i); // 배열 a의 i 위치부터 끝까지에서 가장 작은 값을 찾아서
			swap(a, i, minIndex); // 그 값을 i 위치로 이동한다
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] array = { "dog", "laptop", "coffee", "mouse", "keyboard", "apple", "banana", "person" };
		selectionSort(array);
		System.out.println(Arrays.toString(array));
	}

}
