package net.Backjun.Dp;

import java.util.Scanner;

public class FillTile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] dp = new int[1001];

        dp[1] =1;
        dp[2] = 3;
        for(int i=3;i<=1000;i++){
            dp[i] = (2*dp[i-2]+dp[i-1])%10007;
        }
        System.out.println(dp[n]%10007);
    }
}
