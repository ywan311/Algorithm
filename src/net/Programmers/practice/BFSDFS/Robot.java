package net.Programmers.practice.BFSDFS;

import java.util.*;

//미완성
public class Robot {
    //로봇 객체생성
    //회전구현
    //BFS
    static int[][] arr;
    static boolean[][] visited;
    static int N;
    public int solution(int[][] board) {
        N = board.length;
        Position start = new Position(0,0,0,1);
        arr = board;
        visited = new boolean[board.length][board.length];
        while(start!=null){
        }

        return 0;
    }
    class Position{
        int x1;
        int y1;
        int x2;
        int y2;
        public Position(int x1,  int y1,int x2, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x1=" + x1 +
                    ", y1=" + y1 +
                    ", x2=" + x2 +
                    ", y2=" + y2 +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(new Robot().solution(new int[][]{{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}}));
    }
}
