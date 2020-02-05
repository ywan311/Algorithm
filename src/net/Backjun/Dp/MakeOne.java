package net.Backjun.Dp;

import java.util.Scanner;

public class MakeOne {
    static int[] dp ;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        dp = new int[n+1];
        dp[1]=0;
        if(n>1)dp[2]=1;
        if(n>2)dp[3]=1;
        System.out.println(DFS(n));
    }
    static int DFS(int n){
        if(n==1)return 0;
        if(n<1)return Integer.MAX_VALUE;
        if(dp[n]>0)return dp[n];
        if(n%2==0&&n%3==0)return dp[n] =1+ Math.min(Math.min(DFS(n/2),DFS(n/3)),DFS(n-1));
        else if(n%2==0)return dp[n] =1+ Math.min(DFS(n/2),DFS(n-1));
        else if(n%3==0)return dp[n] =1+ Math.min(DFS(n/3),DFS(n-1));
        else return dp[n] =1+ DFS(n-1);
    }
}
