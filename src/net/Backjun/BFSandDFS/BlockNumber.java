package net.Backjun.BFSandDFS;
import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BlockNumber{
    static int[][] arr;
    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,-1,0,1};
    static  int n;
    static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i=0; i<n; i++) {
            String s = br.readLine();

            for(int j=0; j<n; j++)
                arr[i][j] = s.charAt(j) - '0';
        }
        int total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] == 1) {
                    count = 0;
                    total++;

                    dfs(i, j);

                    pq.add(count);
                }
            }
        }
        bw.write(total + "\n");

        while(!pq.isEmpty())
            bw.write(pq.poll() + "\n");

        bw.flush();

    }
    public static void dfs(int x,int y) {
        arr[x][y] = 0;
        count++;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                if(arr[nx][ny] == 1)
                    dfs(nx, ny);
            }
        }
    }
}
