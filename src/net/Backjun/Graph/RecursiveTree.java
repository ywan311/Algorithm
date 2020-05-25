package net.Backjun.Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RecursiveTree {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        Tree tree = new Tree();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            String str = br.readLine().replaceAll(" ","");
            tree.root.addNode(str.charAt(0),str.charAt(1),str.charAt(2));
        }
        tree.root.preOrder();
        bw.write("\n");
        tree.root.inOrder();
        bw.write("\n");
        tree.root.postOrder();
        bw.flush();
    }
    static class Tree{
        Node root;
        static class Node{
            char value;
            Node left;
            Node right;

            public Node(char value) {
                this.value = value;
                this.left = null;
                this.right = null;
            }

            public Node(char value, char left,char right) {
                this.value = value;
                this.left = new Node(left);
                this.right = new Node(right);
            }
            public void addNode(char value, char left, char right){
                if(this.value==value){
                    if(left!='.')this.left = new Node(left);
                    if(right!='.')this.right = new Node(right);
                    return;
                }else{
                    if(this.left!=null)this.left.addNode(value,left,right);
                    if(this.right!=null)this.right.addNode(value,left,right);
                }
            }
            public void preOrder()throws Exception{
                bw.write(this.value);
                if(this.left!=null)this.left.preOrder();
                if(this.right!=null)this.right.preOrder();
            }
            public void inOrder()throws Exception{
                if(this.left!=null)this.left.inOrder();
                bw.write(this.value);
                if(this.right!=null)this.right.inOrder();
            }
            public void postOrder()throws Exception{
                if(this.left!=null)this.left.postOrder();
                if(this.right!=null)this.right.postOrder();
                bw.write(this.value);
            }

            @Override
            public String toString() {
                return "Node{" +
                        "value=" + value+
                        ", left=" + left +
                        ", right=" + right +
                        '}';
            }
        }

        public Tree() {
            this.root = new Node('A');
        }


        @Override
        public String toString() {
            return "Tree{" +
                    "root=" + root +
                    '}';
        }
    }
}
