package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {
    static boolean[][] inputArr;
    static int[][] result;
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    static Queue<Position> landQueue = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        inputArr=new boolean[Integer.parseInt(size[0])][Integer.parseInt(size[1])];
        result=new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];


        for(int i=0;i<inputArr.length;i++){
            char[] element = br.readLine().toCharArray();
            for(int j =0;j<element.length;j++)
                if(element[j]=='L'){
                    inputArr[i][j] =true;
                    landQueue.add(new Position(i,j));
                }
        }

        System.out.println(Solution());
    }
    public static int Solution(){
        for(Position p : landQueue)BFS(p);
        int answer =0;
        for(int[] a : result)
            for (int b : a)answer = Math.max(answer,b);
        return answer;
    }
    public static void BFS(Position start) {
        Queue<Position> nextQueue = new LinkedList<>();
        ArrayList<Position> nextList = new ArrayList<>();
        boolean[][] visited = new boolean[inputArr.length][inputArr[0].length];
        int dist = 0;
        nextQueue.add(start);
        visited[start.getX()][start.getY()] = true;

        while (true) {
            dist++;
            while (!nextQueue.isEmpty()) {
                Position current = nextQueue.poll();
                for(int i=0;i < 4;i++){

                    int nx = current.getX()+dx[i];
                    int ny = current.getY()+dy[i];

                    if (nx < 0 || ny < 0 || nx >= inputArr.length || ny >= inputArr[0].length) continue;
                    if (visited[nx][ny] || !inputArr[nx][ny]) continue;

                    visited[nx][ny]=true;
                    result[nx][ny] = Math.max(result[nx][ny], dist);
                    nextList.add(new Position(nx, ny));
                }
            }
            if (nextList.isEmpty()) break;
            nextQueue.addAll(nextList);
            nextList.clear();
        }
    }
}
class Position{
    private int x;
    private int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
