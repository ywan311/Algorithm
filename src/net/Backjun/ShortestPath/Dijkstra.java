package net.Backjun.ShortestPath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    static int node,edge;
    static int[] answer;
    static List<List<Node>> list ;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] size = br.readLine().split(" ");
        node = Integer.parseInt(size[0]);
        edge = Integer.parseInt(size[1]);
        answer = new int[node+1];
        list = new ArrayList<>();

        int start = Integer.parseInt(br.readLine());
        Arrays.fill(answer,Integer.MAX_VALUE);
        answer[start]=answer[0]=0;

        for(int i=0;i<=node;i++)list.add(new ArrayList<>());
        for(int i=0;i<edge;i++){
            String input[] = br.readLine().split(" ");
            list.get(Integer.parseInt(input[0])).add(new Node(Integer.parseInt(input[1]),Integer.parseInt(input[2])));
        }
        solve(start);
        for(int i=1;i<answer.length;i++){
            if(answer[i]==Integer.MAX_VALUE)bw.write("INF\n");
            else bw.write(answer[i]+"\n");
        }
        bw.flush();

    }
    static void solve(int start){
        boolean[] visited = new boolean[node+1];
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.distance-o2.distance);

        answer[start]=0;
        queue.add(new Node(start,0));

        while (!queue.isEmpty()){
            Node current = queue.poll();

            if(visited[current.index])continue;
            visited[current.index] = true;

            for(Node n :list.get(current.index)){
                if(answer[n.index]>answer[current.index]+n.distance){
                    answer[n.index] = answer[current.index]+n.distance;
                    queue.add(new Node(n.index,answer[n.index]));
                }
            }
        }

    }
    static class Node{
        int index;
        int distance;
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
