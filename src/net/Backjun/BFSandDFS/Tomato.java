package net.Backjun.BFSandDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int width;
    static int height;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        width = input.nextInt();
        height = input.nextInt();

        arr = new int[height][width];

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = input.nextInt();
                if (arr[i][j] != -1) {
                    min = Math.min(min, arr[i][j]);
                    max = Math.max(max, arr[i][j]);
                }

            }
        }
        if (min > 0) {
            System.out.println(0);
            return;
        } else if (max == 0) {
            System.out.println(-1);
            return;
        }
     System.out.println(bfs());
    }

    public static int bfs() {
        visited = new boolean[height][width];

        Queue<Integer> queueX = new LinkedList();
        Queue<Integer> queueY = new LinkedList();

        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(arr[i][j]==1){
                    queueX.add(j);
                    queueY.add(i);
                    visited[i][j] = true;
                }
            }
        }

        while (!queueX.isEmpty() && !queueY.isEmpty()) {
            int tmpX = queueX.poll();
            int tmpY = queueY.poll();
            for (int i = 0; i < 4; i++) {

                int nx = tmpX + dx[i];
                int ny = tmpY + dy[i];

                if (nx < 0 || nx >= width || ny < 0 || ny >= height) continue;
                if (arr[ny][nx] != 0) continue;

                arr[ny][nx] = arr[tmpY][tmpX] + 1;
                queueX.add(nx);
                queueY.add(ny);

            }
        }
        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (arr[i][j] == 0) {
                    return -1;
                }
                max = Math.max(max, arr[i][j]);
            }
        }
        return max - 1;
    }
}
