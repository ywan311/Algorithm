package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11048 {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        arr = new int[N][M];
        dp = new int[N][M];

        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                arr[i][j]= Integer.parseInt(input[j]);
            }
        }
        dp[0][0]=arr[0][0];
        for(int i=1;i<M;i++)dp[0][i]=dp[0][i-1]+arr[0][i];

        for(int i=1;i<N;i++){
            for(int j=0;j<M;j++){
                if(j==0)dp[i][j]=dp[i-1][j]+arr[i][j];
                else dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1])+arr[i][j];
            }
        }
        System.out.println(dp[N-1][M-1]);
    }
}
