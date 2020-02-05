package net.Backjun.BFSandDFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato2 {
    static int[][][] arr;
    static int[] dx = new int[]{-1, 0, 1, 0, 0 ,0};
    static int[] dy = new int[]{0, -1, 0, 1, 0 ,0};
    static int[] dz = new int[]{0, 0, 0, 0, 1, -1};
    static int width;
    static int height;
    static int stare;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        width = input.nextInt();
        height = input.nextInt();
        stare = input.nextInt();

        arr = new int[stare][height][width];

        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int k=0;k<stare;k++){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    arr[k][i][j] = input.nextInt();
                    if (arr[k][i][j] != -1) {
                        min = Math.min(min, arr[k][i][j]);
                        max = Math.max(max, arr[k][i][j]);
                    }

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

        Queue<Integer> queueX = new LinkedList();
        Queue<Integer> queueY = new LinkedList();
        Queue<Integer> queueZ = new LinkedList();

        for(int k=0;k<stare;k++){
            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++){
                    if(arr[k][i][j]==1){
                        queueX.add(j);
                        queueY.add(i);
                        queueZ.add(k);
                    }
                }
            }
        }

        while (!queueX.isEmpty() && !queueY.isEmpty()&&!queueZ.isEmpty()) {
            int tmpX = queueX.poll();
            int tmpY = queueY.poll();
            int tmpZ = queueZ.poll();
            for (int i = 0; i < 6; i++) {

                int nx = tmpX + dx[i];
                int ny = tmpY + dy[i];
                int nz = tmpZ + dz[i];

                if (nx < 0 || nx >= width || ny < 0 || ny >= height|| nz < 0 || nz >=stare) continue;
                if (arr[nz][ny][nx] != 0) continue;

                arr[nz][ny][nx] = arr[tmpZ][tmpY][tmpX] + 1;
                queueX.add(nx);
                queueY.add(ny);
                queueZ.add(nz);

            }
        }
        for(int[][]a: arr){
            for(int[]b: a)
                System.out.println(Arrays.toString(b));
        }
        int max = 0;
        for(int k=0;k<stare;k++){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (arr[k][i][j] == 0) {
                        return -1;
                    }
                    max = Math.max(max, arr[k][i][j]);
                }
            }
        }
        return max - 1;
    }
}
