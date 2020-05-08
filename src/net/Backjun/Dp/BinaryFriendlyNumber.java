package net.Backjun.Dp;

import java.util.Scanner;

public class BinaryFriendlyNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        long[] dp = new long[91];
        dp[1]=dp[2]=1;

        for(int i=3;i<=90;i++){
            dp[i]= dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
