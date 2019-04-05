package net.skhu.sort.radix;

import java.util.Arrays;

public class RadixSort {

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 16진수로 표현했을 때, nth 자리를 기준으로 정렬한다.
    public static void countingSort(int[] a, int nth) {
    	int[] count = new int[16]; // 16개의 count가 필요함.
        for (int value : a) {
            int digit = value >> (nth * 4) & 0xF; // nth 자리의 값을 구함
            ++count[digit]; // digit 값 count 증가
        }
        // nth 자리의 값을 기준으로 정렬 했을 때, 각 값의 시작 위치 계산
        int[] index = new int[16]; // 시작 위치 배열
        index[0] = 0;
        for (int i = 1; i < index.length; ++i)
            index[i] = index[i - 1] + count[i - 1];

        // 위에서 계산한 시작 위치를 사용하여 값들을 temp 배열에 복사함. 즉 정렬함.
        int[] temp = new int[a.length];
        for (int value : a) {
            int digit = value >> (nth * 4) & 0xF;
            temp[index[digit]++] = value;
        }

        // 정렬된 temp 배열의 값을 입력 배열에 복사
        for (int i = 0; i < a.length; ++i)
            a[i] = temp[i];


    }

    public static void radixSort(int[] a) {
        for (int i = 0; i < 8; ++i)
            countingSort(a, i);
    }

    public static void main(String[] args) {
        int[] a = { 8, 6, 2, 9, 1, 0, 10, 5, 3, 11, 12, 4, 7, 13, 14 };
        radixSort(a);
        System.out.println(Arrays.toString(a));
    }
}