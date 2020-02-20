package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SequenceSum {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        String str[] = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        dp[0] = arr[0];
        int max = dp[0];

        for (int j = 1; j < N; j++) {
            dp[j] = Math.max(arr[j], dp[j - 1] + arr[j]);

            max = Math.max(max, dp[j]);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(max);

    }
}
