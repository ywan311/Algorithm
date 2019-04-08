package net.skhu.recursive;

import java.util.Scanner;

public class Example7a {
	static void print1(int n) {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j <= i; ++j)
				System.out.print("*");
			System.out.println();
		}
	}

	static void print2(int n, int i, int j) {
		if(j<=n) {
			if(i<j) {
				System.out.print("*");
				print2(n,++i,j);
			}
			else {

				System.out.println();
				print2(n,0,++j);	
			}
						
		}
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("행 수를 입력하시오: ");
			int n = scanner.nextInt();
			print1(n);
			System.out.println();
			print2(n, 0, 0);
		}
	}
}