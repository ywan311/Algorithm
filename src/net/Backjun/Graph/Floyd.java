package net.Backjun.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;

public class Floyd {
    static int[][] arr;
    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]) - 1;
            int y = Integer.parseInt(str[1]) - 1;
            arr[x][y] = arr[x][y] == 0 ? Integer.parseInt(str[2]) : Math.min(arr[x][y], Integer.parseInt(str[2]));
        }
        for (int a[] : arr) System.out.println(Arrays.toString(a));

    }

    static void solve(int start, int mid, int dest, int sum) {
        if (start == dest) return;
        visited[start] = true;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && arr[mid][i] > 0) {
                visited[i] = true;
                solve(start, i, dest, sum + arr[mid][i]);
                visited[i] = false;
            }
        }

    }


}
