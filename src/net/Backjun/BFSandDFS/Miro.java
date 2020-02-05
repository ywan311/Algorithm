package net.Backjun.BFSandDFS;

import java.util.*;

public class Miro {
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,-1,0,1};
    static  int a;
    static  int b;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        a =input.nextInt();
        b =input.nextInt();
        matrix = new int[a][b];
        String[] inputArr = new String[a];
        for(int i=0;i<a;i++){
            inputArr[i]= input.next();
        }
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                matrix[i][j] = inputArr[i].charAt(j)-'0';
            }
        }
        visited= new boolean[a][b];
        for(boolean[] arr: visited) Arrays.fill(arr,false);
        findRoute(0,0);
        System.out.println(matrix[a-1][b-1]);
    }
    public static void findRoute(int x,int y) {
        Queue<Dot> queue = new LinkedList<>();
        queue.add(new Dot(x, y));
        while(!queue.isEmpty()){
            Dot tmp = queue.poll();
            for(int i=0;i<4;i++){
                int nextX = tmp.x+dx[i];
                int nextY = tmp.y+dy[i];
                if(nextX<0||nextX>=a||nextY<0||nextY>=b)continue;
                if(visited[nextX][nextY]||matrix[nextX][nextY]==0)continue;
                queue.add(new Dot(nextX,nextY));
                matrix[nextX][nextY] = matrix[tmp.x][tmp.y]+1;
                visited[nextX][nextY] = true;
            }
        }
    }
}
class Dot{
    int x;
    int y;

    public Dot(int x,int y) {
        this.x = x;
        this.y = y;
    }

}
