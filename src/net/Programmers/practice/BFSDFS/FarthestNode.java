package net.Programmers.practice.BFSDFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FarthestNode {
    static boolean[][] matrix;
    static boolean[] visited;
    static int N;

    public int solution(int n, int[][] edge) {
        int answer;
        N = n;
        matrix = new boolean[N][N];
        visited = new boolean[N];

        for (int i[] : edge) {
            matrix[i[0] - 1][i[1] - 1] = true;
            matrix[i[1] - 1][i[0] - 1] = true;
        }
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(0);
        visited[0] = true;
        while (true) {
            answer = queue.size();
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int i = 0; i < N; i++) {
                    if (matrix[current][i] && !visited[i]) {
                        list.add(i);
                        visited[i] = true;
                    }
                }
            }
            if (list.isEmpty()) break;
            queue.addAll(list);
            list.clear();
        }
       /*DFS(0);
       int max=0;
       for (int a:distance ) {
            if(max<a){
                max =a;
                answer =1;
            }else if(max== a)answer++;
        }*/
        return answer;
    }

    /*public static void DFS(int current){
        for(int i=1;i<N;i++){
            if(matrix[current][i]==1){
                if(distance[i]==0){
                    distance[i]= distance[current]+1;
                }
                else {
                    int tmp=Math.min(distance[current]+1, distance[i]);
                    if(tmp==distance[i])continue;
                    else distance[i] = tmp;
                }
                DFS(i);
            }
        }
    }*/


    public static void main(String[] args) {
        System.out.println(new FarthestNode().solution(7, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}, {6, 7}}));
    }
}
