package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DownStare {
    static int N;
    static int M;
    static int[][] arr;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        arr = new int[N][M];
        dp = new int[N][M];


        for(int i=0;i<N;i++){
            String row[] = br.readLine().split(" ");
            for (int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(row[j]);
                dp[i][j]=-1;
            }
        }
        System.out.println(DFS(0,0));

        for(int a[]:dp)System.out.println(Arrays.toString(a));
    }
    static int DFS(int x, int y) {
        if(x==N-1&&y==M-1)return 1;


        if(dp[x][y]!=-1){
            dp[x][y]=0;
            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(arr[nx][ny]<arr[x][y]){
                    dp[x][y] +=DFS(nx,ny);
                }
            }
        }
        return dp[x][y];
    }
}
