package net.Backjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P16234 {
    static int answer = 0;
    static int[][] arr;
    static boolean[][] checked;
    static int N;
    static int L;
    static int R;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        L = Integer.parseInt(size[1]);
        R = Integer.parseInt(size[2]);

        arr = new int[N][N];
        checked = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < 2000; i++) {
            boolean result = start();
            for(int a[] : arr) System.out.println(Arrays.toString(a));
            System.out.println("=============");
            if (!result) answer++;
            else break;
        }
        System.out.println(answer);
    }

    static boolean start() {
        for (int j = 0; j < N; j++) Arrays.fill(checked[j], false);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!checked[i][j]) {
                    BFS(i, j);
                    sum++;
                }
            }
        }
        return sum == N * N ;
    }

    static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        Set<Point> set = new HashSet<>();
        int sum = 0;
        queue.offer(new Point(x, y));
        set.add(new Point(x, y));
        checked[x][y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int cValue = arr[current.x][current.y];
            sum += cValue;

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (checked[nx][ny]) continue;
                int gap = Math.abs(cValue - arr[nx][ny]);
                if (gap < L || gap > R) continue;

                checked[nx][ny] = true;
                set.add(new Point(nx, ny));
                queue.offer(new Point(nx, ny));
            }
        }
        int avg = sum / set.size();
        System.out.println(set);
        System.out.println(avg);
        for (Point p : set) {
            arr[p.x][p.y] = avg;
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
