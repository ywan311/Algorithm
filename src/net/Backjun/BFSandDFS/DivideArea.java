package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DivideArea {
    static int[][] arr;
    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,-1,0,1};
    static int N;
    static int M;
    static boolean visited[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1[] = br.readLine().split(" ");
        N = Integer.parseInt(str1[0]);
        M = Integer.parseInt(str1[1]);
        int tmp = Integer.parseInt(str1[2]);

        arr = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0;i<tmp;i++){
            String[] str2 = br.readLine().split(" ");
            int x1 = Integer.parseInt(str2[0]);
            int y1 = Integer.parseInt(str2[1]);
            int x2 = Integer.parseInt(str2[2]);
            int y2 = Integer.parseInt(str2[3]);
            for(int x=x1;x<x2;x++){
                for(int y=y1;y<y2;y++){
                    arr[x][y] = 1;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]||arr[i][j]==1)continue;
                list.add(BFS(i,j));
            }
        }
        int answer[] = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        System.out.println(answer.length);
        Arrays.sort(answer);
        for(int a:answer)System.out.print(a+" ");

    }
    public static int BFS(int x, int y){
        int size=0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y]=true;
        int[] current;

        while(!queue.isEmpty()){
            current = queue.poll();
            size++;

            for(int i=0;i<4;i++){
                int[] next = new int[]{current[0]+dx[i],current[1]+dy[i]};
                if(next[0]<0||next[0]>=M||next[1]<0||next[1]>=N)continue;
                if(visited[next[0]][next[1]]||arr[next[0]][next[1]]==1)continue;
                visited[next[0]][next[1]]=true;
                queue.add(next);
            }

        }

        return size;
    }
}
