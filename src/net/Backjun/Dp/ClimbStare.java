package net.Backjun.Dp;

import java.util.Arrays;
import java.util.Scanner;

public class ClimbStare {
    static int[] arr;
    static int[] dp;
    static int N;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        arr = new int[N+1];
        dp = new int[N+1];

        for(int i=1;i<=N;i++){
            arr[i] = input.nextInt();
        }
        dp[1]= arr[1];
        if(N==1){
            System.out.println(arr[1]);
            return;
        }
        dp[2]= arr[1]+arr[2];
        if(N==2){
            System.out.println(arr[2]);
            return;
        }
        for(int i=3;i<=N;i++){
            dp[i] = Math.max(dp[i-2]+arr[i],dp[i-3]+arr[i-1]+arr[i]);
        }
        System.out.println(dp[N]);

    }

}
