package net.Backjun.BFSandDFS;

public class RobotCleaner {
    static int N;
    static int M;
    static int[][] arr;
    static int[] dx = new int[]{0,1,0,-1};
    static int[] dy = new int[]{-1,0,1,0};

    public static void main(String[] args) {
        N = 11;
        M = 10;
        Robot r = new Robot(7,4,0);
        arr = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        int sum = 0;
        for(int i[]:arr)for(int j:i)if(j==0)sum++;
        System.out.println(sum);
    }
}

class Robot {
    int x;
    int y;
    int direct;

    public Robot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }
}
