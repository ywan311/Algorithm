package net.Backjun.SegmentTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//세그먼트 트리 개어려움 공부 ㄱㄱ
//미완성

public class MinPair {
    static int[] arr;
    static long[] tree;
    static int n=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String length[] = br.readLine().split(" ");
        int N = Integer.parseInt(length[0]);
        int M = Integer.parseInt(length[1]);
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = (int) Math.ceil(Math.log(N) / Math.log(2));
        tree = new long[(int)Math.pow(2,x)*2];
        makeTree(1,0,N-1);
        int pivot =1;
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
            if(pivot==i+1){
                pivot*=2;
                System.out.println();
            }
        }
        while(M-->0){
            String[] input = br.readLine().split(" ");
            long answer =findAnswer(1,0,N-1,Integer.parseInt(input[0])-1,Integer.parseInt(input[1])-1);
            bw.write(answer+"\n");
        }
        bw.flush();
    }
    static long findAnswer(int node,int start,int end, int left, int right){
        System.out.println(++n+"시간복잡도");
        if(start>right||end<left)return Long.MAX_VALUE;
        if(start>=left&&right>=end)return tree[node];
        int mid = (start+end)/2;
        return Math.min(
                findAnswer(node*2,start,mid,left,right)
                ,findAnswer(node*2+1,mid+1,end,left,right));
    }
    static long makeTree(int node, int start, int end){
        if(start==end)return tree[node]=arr[start];
        int mid = (start+end)/2;

        return tree[node]= Math.min(makeTree(node*2,start,mid),makeTree(node*2+1,mid+1,end));
    }
}
