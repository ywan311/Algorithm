package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class KevinBacon {
    static int N;
    static int arr[][];
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int minIndex=N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < Integer.parseInt(str[1]); i++) {
            String[] element = br.readLine().split(" ");
            arr[Integer.parseInt(element[0]) - 1][Integer.parseInt(element[1]) - 1] = arr[Integer.parseInt(element[1]) - 1][Integer.parseInt(element[0]) - 1] = 1;
        }
        for(int i=0;i<N;i++){
            Arrays.fill(visited,false);
            int tmp =BFS(i);
            if(min>tmp){
                min=tmp;
                minIndex=i;
            }
        }
        System.out.println(minIndex=1);
    }

    static int BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(start);
        visited[start] = true;
        int sum=0;
        int cnt = 0;
        while(true){
            cnt++;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int i = 0; i < N; i++) {
                    if (arr[current][i] > 0 && !visited[i]) {
                        System.out.println(i+"   / "+current);
                        visited[i]=true;
                        list.add(i);
                    }
                }
            }
            if(list.isEmpty())break;
            queue.addAll(list);
            sum+=list.size()*cnt;
            list.clear();
        }
        return sum;
    }

}
