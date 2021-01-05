package net.Backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1937 {
    static int[][] arr;
    static int[][] dp;
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr=new int[N][N];
        dp=new int[N][N];

        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
    }
}
