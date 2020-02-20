package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LBS {
    static int[] arr;
    static int N;
    static int answer=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");

        arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(str[i]);

        int[][] dp = new int[2][N];

        dp[0][0]=1;
        dp[1][0]=1;

        for(int i=1;i<N;i++){
            dp[0][i]=1;
            dp[1][i]=1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[0][i] = Math.max(dp[0][i],dp[0][j]+1);
                }
                if(arr[j]>arr[i]){
                    dp[1][i] = Math.max(dp[1][i],dp[1][j]+1);
                    dp[1][i] = Math.max(dp[1][i],dp[0][j]+1);
                }
            }
            answer = Math.max(answer,Math.max(dp[0][i],dp[1][i]));
        }

        System.out.println(answer);
    }
}
