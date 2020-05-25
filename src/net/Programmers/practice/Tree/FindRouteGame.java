package net.Programmers.practice.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindRouteGame {
    static List<Integer> preOrder = new ArrayList<>();
    static List<Integer> postOrder = new ArrayList<>();
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) ->o2[1]-o1[1]);
        for(int[] a: nodeinfo){
            queue.offer(a);
        }
        Node root = null;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int index =0;
            for(int i=0;i<nodeinfo.length;i++){
                if(nodeinfo[i][0]==current[0]&&nodeinfo[i][1]==current[1]){
                    index = i+1;
                    break;
                }
            }
            if(root==null)root = new Node(current[0],current[1],index);
            else{
                root.add(current,index);
            }
        }
        root.pre();
        root.post();
        answer = new int[2][nodeinfo.length];
        for(int i=0;i<2;i++){
            for(int j=0;j<nodeinfo.length;j++){
                answer[i][j] = i==0?preOrder.get(j):postOrder.get(j) ;
            }
        }
        return answer;
    }
    static class Node{
        Node left;
        Node right;
        int x;
        int y;
        int data;

        public Node(int x, int y,int data) {
            this.x = x;
            this.y = y;
            this.data = data;
            this.left  = null;
            this.right = null;
        }
        void add(int[] pos, int data){
            if(this.x>pos[0]){
                if(this.left==null)this.left = new Node(pos[0],pos[1],data);
                else this.left.add(pos,data);
            }else{
                if(this.right==null)this.right = new Node(pos[0],pos[1],data);
                else this.right.add(pos,data);

            }
        }
        void pre(){
            preOrder.add(this.data);
            if(this.left!=null)this.left.pre();
            if(this.right!=null)this.right.pre();
        }
        void post(){
            if(this.left!=null)this.left.post();
            if(this.right!=null)this.right.post();
            postOrder.add(this.data);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindRouteGame().solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}})));
    }
}
