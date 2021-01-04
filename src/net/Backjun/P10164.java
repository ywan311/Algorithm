package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        if(n==1||m==1){
            System.out.println("1");
            return;
        }

        int[][] dp = new int[n][m];
        int startx = k/m;
        int starty = k%m-1;
        for(int i=0;i<=startx;i++){
            for(int j=0;j<=starty;j++){
                if(i==0||j==0)dp[i][j]=1;
                else dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        int answer = dp[startx][starty];
        for(int i=startx;i<n;i++){
            for(int j=starty;j<m;j++){
                if(i==startx||j==starty)dp[i][j]=1;
                else dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        if(k==0){
            System.out.println(dp[n-1][m-1]);
            return;
        }
        System.out.println(answer*dp[n-1][m-1]);
    }
}
