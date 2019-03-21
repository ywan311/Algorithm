package net.skhu.highLevelSort;

import java.util.Arrays;

public class MergeSort {

	// a 배열에서 start 에서 end 사이의 값을 정렬한다.
	static void mergeSort(int[] a, int start, int end) {
		if (start >= end)
			return;
		else {
			int middle = (start + end) / 2;
			mergeSort(a, start, middle);
			mergeSort(a, middle + 1, end);
			merge(a, start, middle, end);
		}
	}

	// a 배열에서 앞부분(start ~ middle)과 뒷부분(middle+1 ~ end)을 병합한다.
	static void merge(int[] a, int start, int middle, int end) {
		int lenth = end-start+1;
		int[] tmp = new int[lenth];
		int i = middle + 1;// 뒷배열 탐색 인덱스
		int j = start;// 앞배열 탐색 인덱스
		int k = 0;// tmp배열 입력 인덱스
		while (j <= middle && i <= end) {
			if (a[j] < a[i])
				tmp[k++] = a[j++];
			else
				tmp[k++] = a[i++];
		}
		while (j <= middle) {// 앞배열의 정렬이 끝났을때
			tmp[k++] = a[j++];
		}
		while (i <= end) {// 뒷배열의 정렬이 끝났을때
			tmp[k++] = a[i++];
		}
		for (i = 0; i < tmp.length; ++i) // 임시 배열의 내용을 a 배열의 start 위치에 복사한다.
			a[start + i] = tmp[i];


	}

	public static void main(String[] args) {
		int[] a = { 31, 3, 65, 73, 8, 11, 20, 29, 48, 15 };

		mergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

}
