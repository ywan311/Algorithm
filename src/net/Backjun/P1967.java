package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P1967 {
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(1,0);

        int N = Integer.parseInt(br.readLine());

        while(--N>0){
            String[] input = br.readLine().split(" ");
            root.add(Integer.parseInt(input[0]),Integer.parseInt(input[1]),Integer.parseInt(input[2]));
        }

        System.out.println(root);

        max = Math.max(root.getMax(),max);

        System.out.println(max);
    }
    static class Node{
        int index;
        int distance;
        List<Node> children = new ArrayList<>();

        void add(int parent,int current,int distance) {
            if(this.index==parent){
                this.children.add(new Node(current,distance));
            }
            for(Node n : this.children){
                n.add(parent,current,distance);
            }
        }

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        int getMax(){
            System.out.println("getMax :"+this.index);
            if(this.children.size()==0){
                return this.distance;
            }else{
                List<Integer> distanceList = this.children.stream().map(Node::getMax).sorted(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2-o1;
                    }
                }).collect(Collectors.toList());
                if(distanceList.size()>=2){
                    max = Math.max(max,distanceList.get(0)+distanceList.get(1));
                    System.out.println(distanceList);
                }
                System.out.println(this.distance+distanceList.get(0));
                return this.distance+distanceList.get(0);
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", distance=" + distance +
                    ", children=" + children +
                    '}'+"\n";
        }
    }

}
