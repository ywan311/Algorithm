package net.Backjun.ShortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Bus {
    static int node,edge;
    static int answer[];
    static List<List<Node>> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        answer = new int[node+1];

        for(int i=0;i<=node;i++)list.add(new ArrayList<>());
        for(int i=0;i<edge;i++){
            String[] input = br.readLine().split(" ");
            list.get(Integer.parseInt(input[0])).add(new Node(Integer.parseInt(input[1]),Integer.parseInt(input[2])));
        }
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int dest = Integer.parseInt(input[1]);

        Arrays.fill(answer,Integer.MAX_VALUE);
        solve(start);
        System.out.println(answer[dest]);
    }
    static void solve(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.price-o2.price);

        answer[start]=0;
        queue.add(new Node(start,0));

        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(list.get(current.index).size()==0)continue;
            for(Node n: list.get(current.index)){
                if(answer[n.index]>answer[current.index]+n.price){
                    answer[n.index]=answer[current.index]+n.price;
                    queue.offer(new Node(n.index,n.price));
                }
            }
        }
    }
    static class Node{
        int index;
        int price;

        public Node(int index, int price) {
            this.index = index;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", price=" + price +
                    '}';
        }
    }
}
