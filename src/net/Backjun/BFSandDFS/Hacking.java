package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hacking {
    static int N;
    static int M;
    static ArrayList<Integer>[] list;
    static int[] dp;
    static boolean visited[];
    static int depth=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        dp = new int[N+1];
        visited = new boolean[N+1];
        list = (ArrayList<Integer>[]) new ArrayList[N+1];
        int max=0;

        for(int i=1;i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            String str1[] = br.readLine().split(" ");
            list[Integer.parseInt(str1[0])].add(Integer.parseInt(str1[1]));
        }
        for(int i=1;i<list.length;i++){
            Arrays.fill(visited,false);
            DFS(i);
        }
        List<Integer> answer = new ArrayList<>();
        for(int i:dp)max = Math.max(i,max);
        for(int i=1;i<dp.length;i++){
            if(dp[i]==max)answer.add(i);
        }
        System.out.println(Arrays.toString(dp));
        for(int i:answer)bw.write(i+" ");
        bw.flush();
    }
    static void DFS(int index){
        visited[index]=true;

        for(int i: list[index]){
            if(!visited[i]){
                dp[i]++;
                DFS(i);
            }
        }
    }
}
