package net.Backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

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

        for(int i=1;i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            String str1[] = br.readLine().split(" ");
            list[Integer.parseInt(str1[1])].add(Integer.parseInt(str1[0]));
        }

        for(int i=1;i<N+1;i++){
            visited[i] = true;
            int r =DFS(i);
            visited[i] =false;
            depth = Math.max(depth,r);
        }
        for(int i=1;i<N+1;i++){
            if(dp[i]==depth)bw.write(i+" ");
        }
        bw.flush();
    }
    static int DFS(int current){

        if(dp[current]!=0)return dp[current];
        dp[current]=1;
        for(int a:list[current]){
            if(!visited[a]){
                visited[a]=true;
                dp[current]+=DFS(a);
                visited[a] =false;
            }
        }
        return dp[current];
    }
    long solution(long a){
        char[] s = String.valueOf(a).toCharArray();
        StringBuilder answer = new StringBuilder();

        for(int i=s.length-1;i>0;i--){
            answer.append(s[i]);
        }
        return Long.parseLong(answer.toString());

    }
}
