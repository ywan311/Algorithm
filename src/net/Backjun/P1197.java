package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class P1197 {
    static ArrayList<Node>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        int V = Integer.parseInt(size[0]);
        int E = Integer.parseInt(size[1]);

        adj = new ArrayList[V+1];
        for(int i =0;i<adj.length;i++){
            adj[i] = new ArrayList<>();
        }


        for(int i =0 ;i< E;i++){
            String[] input = br.readLine().split(" ");
            adj[Integer.parseInt(input[0])].add(new Node(Integer.parseInt(input[1]),Integer.parseInt(input[2])));
            adj[Integer.parseInt(input[1])].add(new Node(Integer.parseInt(input[0]),Integer.parseInt(input[2])));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.wight-o2.wight);
        long answer = 0L;
        pq.add(new Node(1,0));

        boolean[] visited = new boolean[V+1];

        while(!pq.isEmpty()){
            Node current = pq.poll();
            if(visited[current.to]){
                continue;
            }
            answer+= current.wight;
            visited[current.to]=true;

            for(Node next : adj[current.to]){
                if(visited[next.to])continue;
                pq.add(next);
            }
        }
        System.out.println(answer);

        
    }
    static class Node {
        int to;
        int wight;
        public Node(int to, int wight) {
            this.to = to;
            this.wight = wight;
        }
    }
}
