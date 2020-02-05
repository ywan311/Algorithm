package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class FindRoute {
    static int N;
    static int[][] matrix;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        for(int i=0;i<N;i++){ //입력
            String[] s = br.readLine().split(" ");
            for(int j=0;j<s.length;j++){
                matrix[i][j] = Integer.parseInt(s[j]);
            }

        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(matrix[i][j]==1){
                    queue.add(j);
                }
                while(!queue.isEmpty()){
                    int tmp = queue.poll();
                    BFS(i, tmp);
                }
            }
        }

        for(int i[]:matrix){// 출력
            for(int j:i){
                bw.write(String.valueOf(j)+" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    public static void BFS(int start, int next) {
        matrix[start][next]=1;
        for(int i=0;i<N;i++){
            if(matrix[next][i]==1&&matrix[start][i]==0)
                queue.add(i);
        }
    }
}
