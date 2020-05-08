package net.Backjun.Dp;

import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        int pisano = 1500000;
        long[] dp = new long[pisano];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<pisano&&i<=n;i++){
            dp[i]= (dp[i-1]+dp[i-2])%1000000;
        }
        System.out.println(dp[(int)n%pisano]);
    }
}
