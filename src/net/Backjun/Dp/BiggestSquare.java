package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BiggestSquare {
    static int N;
    static int M;
    static int[][] arr;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String size[] = br.readLine().split(" ");
        N =Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        arr = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            String input = br.readLine();
            for(int j=1;j<=M;j++)arr[i][j] = input.charAt(j-1)-'0';
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(arr[i][j]==1){
                    arr[i][j] = 1+ Math.min(arr[i-1][j-1],Math.min(arr[i-1][j],arr[i][j-1]));
                    max = Math.max(max,arr[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}
