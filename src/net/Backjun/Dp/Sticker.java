package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sticker {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n-->0){
            int size = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][size+1];
            int[][] dp = new int[2][size+1];

            String[] str1 = br.readLine().split(" ");
            for(int i=0;i< str1.length;i++)arr[0][i+1] = Integer.parseInt(str1[i]);

            String[] str2 = br.readLine().split(" ");
            for(int i=0;i<size;i++)arr[1][i+1] = Integer.parseInt(str2[i]);

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for(int i=2;i<dp[0].length;i++){
                dp[0][i] = Math.max(Math.max(dp[0][i-2],dp[1][i-1])+arr[0][i],dp[0][i-1]);
                dp[1][i] = Math.max(Math.max(dp[1][i-2],dp[0][i-1])+arr[1][i],dp[1][i-1]);
            }
            System.out.println(Math.max(dp[0][dp[0].length-1],dp[1][dp[0].length-1]));
        }
    }
}
