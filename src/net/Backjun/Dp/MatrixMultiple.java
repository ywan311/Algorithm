package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixMultiple {
    static int[][] matrix;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(br.readLine());

        dp= new int[n][n];
        matrix = new int[n][2];
        for(int i=0;i<n;i++){
            String[] input = br.readLine().split(" ");
            matrix[i][0] = Integer.parseInt(input[0]);
            matrix[i][1] = Integer.parseInt(input[1]);
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        System.out.println(getMin(0,n-1));
    }
    static int getMin(int start, int end){
        if(start==end)return 0;
        if(dp[start][end]!=Integer.MAX_VALUE)return dp[start][end];

        for(int i=start;i<end;i++){
             dp[start][end] = Math.min(dp[start][end],(getMin(start,i)+getMin(i+1,end)+matrix[start][0]*matrix[i][1]*matrix[end][1]));
        }
        return dp[start][end];
    }
}
