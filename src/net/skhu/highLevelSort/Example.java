package net.skhu.highLevelSort;

import java.util.Random;

public class Example {// 1번 홀수짝수 분리 홀수가 뒤, 짝수가 앞 짝수는 정렬 퀵소트 활용
						// 2번 문자정렬 소문자char[]배열에서 알파벳순으로 정렬 int[] cnt 배열활용
	static int[] sort(int[] a) {
		int start = 0;
		int end = a.length - 1;

		while (start < end) {
			while (a[start] % 2 != 0) {
				start++;
			}
			while (a[end] % 2 == 0) {
				end--;
			}
			if (start <= end) {
				int tmp = a[start];
				a[start] = a[end];
				a[end] = tmp;
			}

		}

		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int a[] = new int[10];
		for (int i = 0; i < a.length - 1; i++) {
			a[i] = random.nextInt(30);
			System.out.print(" " + a[i]);
		}
		System.out.println();
		int b[] = sort(a);
		for (int i = 0; i < b.length - 1; i++) {
			System.out.print(" " + b[i]);
		}

	}

}
