package net.Backjun.Dp;

import java.util.Scanner;

public class Plus123 {
    static int[] dp = new int[12];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        for(int i=4;i<12;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        int n = input.nextInt();

        while(n-->0) {
            int number = input.nextInt();
            System.out.println(dp[number]);
        }

    }
}
