package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HapDivide {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        long arr[][] = new long[201][201];
        for (int i = 1; i <= 200; i++) {
            for (int j = 1; j <= 200; j++) {
                if (i == 1) arr[i][j] = j;
                else if (j == 1) arr[i][j] = 1;
                else arr[i][j] = (arr[i - 1][j] + arr[i][j - 1]) % 1000000000;
            }
        }
        System.out.println(arr[n][k]);
    }
}
