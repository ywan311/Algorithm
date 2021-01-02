package net.Backjun.BFSandDFS;

import java.io.*;

public class TermProject {
    static int[] input;
    static boolean[] visited;
    static boolean[] finished;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseNum = Integer.parseInt(br.readLine());

        while(caseNum-->0){
            count =1;
            int size = Integer.parseInt(br.readLine())+1;
            input = new int[size];

            String[] element = br.readLine().split(" ");
            visited = new boolean[size];
            finished = new boolean[size];

            for(int i=1;i<size;i++){
                input[i] = Integer.parseInt(element[i-1]);
            }

            for(int i=1;i<size;i++){
                DFS(i);
            }
            bw.append(String.valueOf(size-count)).append("\n");
        }
        bw.flush();
    }
    static void DFS(int current) {
        if(visited[current])return;

        visited[current] = true;
        int next = input[current];

        if(!visited[next])DFS(next);
        else{
            if(!finished[next]){
                count++;
                for(int i=next;i!=current;i=input[i]){
                    count++;
                }
            }
        }
        finished[current] =true;
    }

}
