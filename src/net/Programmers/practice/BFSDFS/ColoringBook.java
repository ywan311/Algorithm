package net.Programmers.practice.BFSDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {
    public int[] solution(int m, int n, int[][] picture) {

        int[][] arr;
        boolean[][] visited;
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        int[] answer = new int[]{0,0};
        arr = new int[100][100];
        visited = new boolean[100][100];


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=picture[i][j];
            }
        }



        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]>0&&!visited[i][j]){
                    int size=0;
                    int value = arr[i][j];

                    queue.offer(new int[]{i,j});
                    visited[i][j]=true;

                    int[] current;
                    while(!queue.isEmpty()){
                        current = queue.poll();
                        size++;

                        for(int k=0;k<4;k++){
                            int nx = current[0]+dx[k];
                            int ny = current[1]+dy[k];

                            if(nx<0||ny<0||nx>=arr.length||ny>=arr[0].length)continue;
                            if(visited[nx][ny])continue;
                            if(arr[nx][ny]==value){
                                visited[nx][ny]=true;
                                queue.offer(new int[]{nx,ny});
                            }
                        }
                    }
                    answer[0]++;
                    answer[1] = Math.max(answer[1],size);
                }
            }
        }
        return answer;
    }
    static void BFS(int x,int y){


    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ColoringBook().solution(	13, 16, new int[][]{{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0}
        , {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
        {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
        {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0},
        {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
        {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
        {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0},
        {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}})));
    }
}
