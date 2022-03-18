package net.Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rank {
    static List<Integer>[] graph;
    static int[][] counts;

    public int solution(int n, int[][] results) {
        int answer = 0;
        counts = new int[n+1][n+1];
        graph =(List<Integer>[]) new List[n+1];

        for(int i =1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] i : results){
            graph[i[0]].add(i[1]);
        }

        for(int i =1;i<=n;i++){
            DFS(i,i,new boolean[n+1]);
        }

        for(int i =1;i<=n;i++){
            int sum=0;
            for(int j =1;j<=n;j++){
                if(i==j)continue;
                sum+=counts[i][j];
                sum+=counts[j][i];
            }
            if(sum>=n-1){
                answer++;
            }
        }
        return answer;
    }
    void DFS(int start,int index,boolean[] checked){
        checked[index]=true;
        counts[start][index]++;

        for(int i : graph[index]){
            if(!checked[i]){
                DFS(start,i,checked);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(new Rank().solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }
}
