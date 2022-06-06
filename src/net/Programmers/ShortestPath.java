package net.Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPath {
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    static boolean[][] checked ;
    public int solution(int[][] maps) {
        int answer = 1;
        int n = maps.length;
        int m = maps[0].length;
        checked = new boolean[n][m];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));

        List<Point> nextList = new ArrayList<>();

        while(true){
            answer++;
            while(!queue.isEmpty()){
                Point current = queue.poll();

                for(int i = 0;i<4;i++){
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];

                    if(nx==n-1 && ny==m-1){
                        return answer;
                    }
                    if(nx<0 || ny <0 || nx>=n || ny >= m){
                        continue;
                    }
                    if(checked[nx][ny]){
                        continue;
                    }
                    if(maps[nx][ny]!=1){
                        continue;
                    }
                    checked[nx][ny]=true;
                    nextList.add(new Point(nx,ny));
                }
            }
            if(nextList.isEmpty()){
                return -1;
            }else{
                queue.addAll(nextList);
                nextList.clear();
            }
        }

    }
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {

        System.out.println(new ShortestPath().solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
    }
}
