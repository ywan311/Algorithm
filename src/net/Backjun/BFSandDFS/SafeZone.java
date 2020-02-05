package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SafeZone {
    static int[][] arr;
    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,-1,0,1};
    static  int n;
    static int answer=1;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int max=0;

        for(int i=0; i<n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j=0;j<s.length;j++){
                arr[i][j] = Integer.parseInt(s[j]);
                max = Math.max(arr[i][j], max);
            }
        }
        for(int i=1;i<=max;i++){

            visited = new boolean[n][n];
            int tmpAnswer=0;
            for(int x=0;x<n;x++){
                for(int y=0;y<n;y++){
                    if(visited[x][y]||arr[x][y]<=i)continue;
                    BFS(x,y,i);
                    tmpAnswer++;
                }
            }
            answer = Math.max(answer,tmpAnswer);
        }
        System.out.println(answer);

    }
    public static void BFS(int x,int y,int rainValue){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        int[] current;

        while(!queue.isEmpty()){
            current = queue.poll();

            for(int i=0;i<4;i++){
                int[] next = new int[]{current[0]+dx[i],current[1]+dy[i]};

                if(next[0]<0||next[0]>=n||next[1]<0||next[1]>=n)continue;
                if(arr[next[0]][next[1]]<=rainValue||visited[next[0]][next[1]])continue;
                queue.add(next);
                visited[next[0]][next[1]]=true;
            }
        }
        for(boolean[] a:visited)System.out.println(Arrays.toString(a));

    }
}
