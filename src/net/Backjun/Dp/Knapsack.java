package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//미완
public class Knapsack {
    static int N;
    static int K;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);

        arr = new int[N+1][2];
        dp = new int[N+1][K+1];


        for(int i=1;i<N;i++){
            String[] str2 = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str2[0]);
            arr[i][1] = Integer.parseInt(str2[1]);
        }
        int max=0;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<K+1;j++){
                dp[i][j]=dp[i-1][j];
                if(j-arr[i][0]>=0){
                    dp[i][j]= Math.max(dp[i-1][j],dp[i-1][j-arr[i][0]]+arr[i][1]);
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}
