package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class StartLink {
    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static boolean[] visited = new boolean[10000001];
    static int arr[];
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        F = Integer.parseInt(str[0]);
        S = Integer.parseInt(str[1]);
        G = Integer.parseInt(str[2]);
        U = Integer.parseInt(str[3]);
        D = Integer.parseInt(str[4]);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        visited[S] = true;
        arr = new int[F + 1];
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == G) {
                break;
            }
            if (current + U <= F && !visited[current + U]) {
                visited[current + U] = true;
                queue.add(current + U);
                arr[current + U] = arr[current] + 1;
            }
            if (current - D > 0 && !visited[current - D]) {
                visited[current - D] = true;
                queue.add(current - D);
                arr[current - D] = arr[current] + 1;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(S!=G&&arr[G]==0?"use the stairs":arr[G]);
    }
}
