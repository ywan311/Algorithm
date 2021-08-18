package net.Backjun.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P5639 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list  =new ArrayList<>();
        String s;
        while(( s = br.readLine())!=null&&!s.equals("")){
            list.add(Integer.parseInt(s));
        }

        Node root = new Node(list.get(0));
        for(int i=1;i<list.size();i++){
            root.add(list.get(i));
        }
        root.print();
    }
    static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
        public void add(int value){
            if(this.value<value) {
                if(this.right != null)this.right.add(value);
                else this.right = new Node(value);
            }else if(this.value>value) {
                if(this.left != null)this.left.add(value);
                else this.left = new Node(value);
            }
        }
        public void print(){
            if(left!=null)this.left.print();
            if(right!=null)this.right.print();
            System.out.println(value);
        }
    }
}
