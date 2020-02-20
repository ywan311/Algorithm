package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Escape {
    static int R;
    static int C;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static Queue<int[]> waterQueue= new LinkedList<>();
    static int[] start;
    static int[] destination;
    static int answer=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String size[] = br.readLine().split(" ");
        R = Integer.parseInt(size[0]);
        C = Integer.parseInt(size[1]);

        arr = new char[R][C];
        visited = new boolean[R][C];


        for(int i=0;i<R;i++) {
            String str = br.readLine().replaceAll(" ", "");
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'S') start = new int[]{i,j};
                else if (arr[i][j] == 'D') destination = new int[]{i,j};
                else if (arr[i][j] == '*') waterQueue.offer(new int[]{i,j});
            }
        }
        move();
    }
    static void spreadWater(){
        ArrayList<int[]> list = new ArrayList<>();
        int[] current;
        while(!waterQueue.isEmpty()){
            current = waterQueue.poll();

            for (int i=0;i<4;i++){
                int nx = current[0]+dx[i];
                int ny = current[1]+dy[i];
                if(nx<0||ny<0||nx>=R||ny>=C)continue;
                if(visited[nx][ny]||arr[nx][ny]!='.')continue;
                arr[nx][ny]='*';

                list.add(new int[]{nx,ny});
            }
        }
        waterQueue.addAll(list);
        list.clear();

    }
    static void move() {
        Queue<int[]> nextQueue = new LinkedList<>();
        ArrayList<int[]> list = new ArrayList<>();

        nextQueue.offer(start);
        visited[start[0]][start[1]]=true;
        int[] current;
        while(true){
            spreadWater();
            while (!nextQueue.isEmpty()) {
                current = nextQueue.poll();

                for(int i=0;i<4;i++){
                    int nx = current[0]+dx[i];
                    int ny = current[1]+dy[i];

                    if(nx==destination[0]&&ny==destination[1]){
                        System.out.println(answer+1);
                        return;
                    }

                    if(nx<0||ny<0||nx>=R||ny>=C)continue;
                    if(visited[nx][ny]||arr[nx][ny]!='.')continue;

                    list.add(new int[]{nx,ny});
                    visited[nx][ny]=true;
                }
            }
            if(list.isEmpty()){
                System.out.println("KAKTUS");
                return;
            }
            answer++;
            nextQueue.addAll(list);
            list.clear();

        }
    }
}