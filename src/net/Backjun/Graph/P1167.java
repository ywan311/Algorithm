package net.Backjun.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P1167 {
    static int size;
    static int[][] arr ;
    static boolean[] check;
    static int[] dist;
    static ArrayList<Edge>[] list;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());

        check = new boolean[size];

        arr = new int[size][size];

        list =(ArrayList<Edge>[])new ArrayList[size];

        for(int i=0;i<size;i++){
            String[] input = br.readLine().split(" ");
            int node = Integer.parseInt(input[0])-1;
            list[i] = new ArrayList<>();
            for(int j=1;j<input.length;j+=2){
                if(input[j].equals("-1"))break;
                list[node].add(new Edge(Integer.parseInt(input[j])-1,Integer.parseInt(input[j+1])));
            }
        }

        for(int []a :arr) System.out.println(Arrays.toString(a));
    }
    static class Edge{
        int v;
        int weight;

        public Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }
    static int dijkstra(int start){
        PriorityQueue<Edge> queue = new PriorityQueue<>((o1, o2) -> o1.weight-o2.weight);
        boolean[] check = new boolean[size];

        for(int i=0 ;i <size;i++){
            
        }
        
        return 0;
    }
}
