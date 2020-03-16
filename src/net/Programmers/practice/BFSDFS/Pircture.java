package net.Programmers.practice.BFSDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pircture {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static int Max =0;
    static int C=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String size[] = br.readLine().split(" ");
        N =Integer.parseInt(size[0]);
        M =Integer.parseInt(size[1]);

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            String str[] = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        for(int[] a: arr)System.out.println(Arrays.toString(a));

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]&&arr[i][j]==1)BFS(i,j);
            }
        }
        System.out.println(C+"\n"+Max);
    }
    static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y]=true;
        int sum=0;
        C++;
        ArrayList<int[]> list = new ArrayList<>();
        while(true){
            int[] current;
            while(!queue.isEmpty()){
                current = queue.poll();
                sum++;
                for(int i=0;i<4;i++){
                    int nx = current[0]+dx[i];
                    int ny = current[1]+dy[i];

                    if(nx<0||ny<0||nx>=N||ny>=M)continue;
                    if(arr[nx][ny]==0||visited[nx][ny])continue;

                    list.add(new int[]{nx, ny});
                    visited[nx][ny]=true;
                }
            }
            if(list.isEmpty())break;
            queue.addAll(list);
            list.clear();
        }
        Max = Math.max(sum,Max);
    }

}
