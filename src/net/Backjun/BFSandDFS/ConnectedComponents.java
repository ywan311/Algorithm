package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConnectedComponents {
    static int[][] matrix;
    static int N;
    static int L;
    static boolean visited[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");
        N=Integer.parseInt(str[0]);
        L=Integer.parseInt(str[1]);

        matrix= new int[N][N];
        visited = new boolean[N];
        int answer=0;
        for(int i=0;i<L;i++){
            String str2[] = br.readLine().split(" ");
            matrix[Integer.parseInt(str2[0])-1][Integer.parseInt(str2[1])-1]=1;
            matrix[Integer.parseInt(str2[1])-1][Integer.parseInt(str2[0])-1]=1;
        }
        for(int i=0;i<N;i++){
            if(visited[i])continue;
            answer++;
            DFS(i);
        }
        System.out.println(answer);
    }
    public static void DFS(int start){
        visited[start]=true;
        for(int i=0;i<N;i++){
            if(!visited[i]&&matrix[start][i]==1){
                DFS(i);
            }
        }
    }
}
