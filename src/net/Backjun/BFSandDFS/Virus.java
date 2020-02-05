package net.Backjun.BFSandDFS;

import java.util.Arrays;
import java.util.Scanner;

public class Virus {
    static int[][] matrix;
    static boolean[] visited;
    static int a ;
    static int b ;
    static int answer=0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       a = input.nextInt();
       b = input.nextInt();
       matrix = new int[a+1][a+1];
        for(int i=0;i<b;i++){
            int x = input.nextInt();
            int y = input.nextInt();
            matrix[x][y] =1;
            matrix[y][x] =1;
        }
        visited = new boolean[a+1];
        DFS(1);
        System.out.println(answer);
    }
    public static void DFS(int value){
        if(!visited[value]){
            visited[value] = true;
            for(int i=1;i<=a;i++){
                if(matrix[value][i]==1&&!visited[i]){
                    answer++;
                    DFS(i);
                }
            }
        }
    }
}
