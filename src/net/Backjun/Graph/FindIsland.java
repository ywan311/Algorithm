package net.Backjun.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindIsland {
    static int[][] arr;
    static boolean[][] visited;
    static int W;
    static int H;
    static int[] dx = new int[]{1, 0, 1,-1,0,-1 ,1,-1};
    static int[] dy = new int[]{0, 1, 1,0, -1,-1,-1,1};
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] size = br.readLine().split(" ");
            if (Integer.parseInt(size[0]) == 0 && Integer.parseInt(size[1]) == 0) break;
            W = Integer.parseInt(size[1]);
            H = Integer.parseInt(size[0]);

            arr = new int[W][H];
            visited = new boolean[W][H];
            for (int i = 0; i < W; i++) {
                String[] str = br.readLine().split(" ");
                for (int j = 0; j < H; j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }
            for (int i = 0; i < W; i++) {
                for (int j = 0; j < H; j++) {
                    if (visited[i][j] || arr[i][j] == 0) continue;
                    BFS(i, j);
                }
            }
            System.out.println(answer);
            answer=0;
        }
    }

    static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
                if (visited[nx][ny] || arr[nx][ny] == 0) continue;

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        answer++;
    }
}
