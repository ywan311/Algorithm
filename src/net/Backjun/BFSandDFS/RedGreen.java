package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RedGreen {
    static char[][] arr;
    static int N;
    static int weakness;
    static int normal;
    static boolean flag = false;
    static boolean[][] visited;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = str.charAt(j);
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j])BFS(i,j);
            }
        }
        flag=true;
        for(boolean[] a: visited)Arrays.fill(a,false);
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j])BFS(i,j);
            }
        }
        System.out.println(weakness+" "+normal);
    }
    static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        int[] current;
        char c = arr[x][y];
        while(!queue.isEmpty()){
            current = queue.poll();
            if(c=='G')arr[current[0]][current[1]]='R';

            for(int i=0;i<4;i++){
                int nx = current[0]+dx[i];
                int ny = current[1]+dy[i];

                if(nx<0||ny<0||nx>=N||ny>=N)continue;
                if(c!=arr[nx][ny]||visited[nx][ny])continue;

                visited[nx][ny]=true;
                queue.add(new int[]{nx,ny});
            }
        }
        if(flag)normal++;
        else weakness++;

    }
}
