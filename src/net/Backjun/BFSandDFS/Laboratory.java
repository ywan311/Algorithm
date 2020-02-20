package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Laboratory {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] copyArr;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static ArrayList<Dot> list = new ArrayList<>();
    static int answer=0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[N][M];
        copyArr = new int[N][M];


        for(int i=0;i<N;i++){
            String str2[] = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(str2[j]);
                if(arr[i][j]==2)list.add(new Dot(i,j));
            }
        }
        makeWall(0,0);
        System.out.println(answer);
    }
    static void makeWall(int start,int depth){
        if(depth==3){
            copyArray();
            for(Dot d:list)spreadVirus(d.x,d.y);

            int tmp=0;
            for(int[] a:copyArr){
                for(int b:a)if(b==0)tmp++;
            }
            answer = Math.max(tmp,answer);
            return;
        }

        for(int i=start;i<N*M;i++){
            int x = i/M;
            int y = i%M;

            if(arr[x][y]==0){
                arr[x][y]=1;
                makeWall(start+1,depth+1);
                arr[x][y]=0;
            }
        }

    }
    static void spreadVirus(int x,int y){
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(0 <= nx && nx < N && 0 <= ny && ny < M){
                if(copyArr[nx][ny]==0){
                    copyArr[nx][ny]=2;
                    spreadVirus(nx,ny);
                }
            }
        }
    }
    static void copyArray(){
        for(int i=0;i<N;i++)
            for(int j=0;j<M;j++)
                copyArr[i][j] = arr[i][j];
    }
    private static class Dot{
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
