package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Retire {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[][] arr = new int[size + 10][2];
        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            arr[i + 1][0] = Integer.parseInt(input[0]);
            arr[i + 1][1] = Integer.parseInt(input[1]);
        }
        int answer = 0;
        int[] dp = new int[size + 10];
        for (int i = 1; i <= size + 1; i++) {
            dp[i] = Math.max(dp[i], answer);
            dp[arr[i][0] + i] = Math.max(dp[arr[i][0] + i], arr[i][1] + dp[i]);

            answer = Math.max(answer, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(answer);
    }
}
