package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Virus2 {
    static int N;
    static int M;
    static int[][] arr;
    static List<Dot> dotList = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        N =Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        arr = new int[N][N];
        for(int i=0;i<N;i++){
            String input[] = br.readLine().split(" ");
            for(int j =0;j<N;j++){
                arr[i][j] = Integer.parseInt(input[j]);
                if(arr[i][j]==2)dotList.add(new Dot(i,j));
            }
        }
    }
    static class Dot{
        int x;
        int y;
        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
