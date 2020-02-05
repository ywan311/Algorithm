package net.Backjun.BFSandDFS;

import java.util.Scanner;

public class Cabbage {
    static boolean[][] arr;
    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,-1,0,1};
    static int x;
    static int y;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        for(int i=0; i<n; i++) {
            x =input.nextInt();
            y =input.nextInt();
            int length =input.nextInt();

            arr = new boolean[y][x];
            for(int j=0; j<length; j++){
                int inputX =input.nextInt();
                int inputY =input.nextInt();
                arr[inputY][inputX]=true;
            }
            int cnt =0;
            for(int i2=0;i2<y;i2++){
                for(int j2=0;j2<x;j2++){
                    if(arr[i2][j2]==true){
                        cnt++;
                        dfs(i2,j2);
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    public static void dfs(int y1,int x1) {
        arr[y1][x1] = false;


        for(int i=0; i<4; i++) {
            int nx = x1 + dx[i];
            int ny = y1 + dy[i];
            if(0 <= nx && nx < x&& 0 <= ny && ny < y) {
                if(arr[ny][nx] == true)
                    dfs(ny, nx);
            }
        }
    }
}

