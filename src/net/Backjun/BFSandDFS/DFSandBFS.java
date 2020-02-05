package net.Backjun.BFSandDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DFSandBFS {
    static ArrayList<Integer> BFSanswer = new ArrayList<>();
    static Boolean visited[];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//정점의 개수
        int m = input.nextInt();//간선의 개수
        int v = input.nextInt();//첫번째 시작 정점


        int matrix[][] = new int[n + 1][n + 1];

        visited = new Boolean[n+1];
        for (int i = 0; i < m; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            matrix[x][y] = 1;
            matrix[y][x] = 1;
        }
        Arrays.fill(visited,false);
        DFS(matrix, v);
        System.out.println();
        Arrays.fill(visited,false);
        BFS(matrix, v);

    }

    public static void BFS(int[][] matrix, int v) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(v);
        visited[v] = true;
        while(!list.isEmpty()){
            int tmp = list.remove(0);
            System.out.print(tmp+" ");
            for(int i=1;i<matrix.length;i++){
                if(matrix[tmp][i]>0&&!visited[i]){
                    list.add(i);
                    visited[i]=true;
                }
            }
        }
    }

    public static void DFS(int[][] matrix, int v) {
        System.out.print(v + " ");
        visited[v] = true;
        for (int i = 1; i < matrix[v].length; i++) {
            if (matrix[v][i] > 0 && !visited[i]) {
                DFS(matrix, i);
            }
        }
    }
}

