package net.skhu.highLevelSort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        System.out.println("i="+i+"j="+j+Arrays.toString(a));
    }

    static int partition(int[] a, int start, int end) {
        int value = a[end];                    // 기준값
        int i = start - 1;                     // i는 1구역의 끝지점
        for (int j = start; j <= end - 1; ++j) {
        	// j는 3구역의 시작 지점
            if (a[j] < value) {          // a[j] 값이 1구역에 속하면
            	System.out.print("j="+j+"end="+end);
            	swap(a, ++i, j);
            }
        }// a[j] 값을 1구역의 끝에 추가한다. 1구역 크기 1증가.
        swap(a, i + 1, end);           // 기준값인 a[end] 원소와 2구역의 시작 원소를 교환한다.
        return i + 1;                  // 기준값 위치 리턴
    }

    static void quickSort(int[] a, int start, int end) {
        if (start >= end) return;
        int middle = partition(a, start, end); // 배열 나누기
        quickSort(a, start, middle-1);         // 1구역 정렬
        quickSort(a, middle+1, end);           // 2구역 정렬
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = {4,1,3,5,7,2,6};

        System.out.println(Arrays.toString(a));
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
