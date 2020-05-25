package net.Backjun.SegmentTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SessionMultiple {
    static long[] arr;
    static long[] tree;
    static int N,M,K;
    static int mod = 1000000007;

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        K = Integer.parseInt(str[2]);

        arr= new long[N];
        int x = (int)Math.ceil(Math.log(N)/Math.log(2));
        tree = new long[(int)Math.pow(2,x)*2];

        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        int i=M+K;
        makeTree(1,0,N-1);
        while(i-->0){
            String[] comm = br.readLine().split(" ");
            if(Integer.parseInt(comm[0])==1){
                int index = Integer.parseInt(comm[1])-1;
                long value = Long.parseLong(comm[2]);
//                long d = arr[index];
                arr[index] =value;
//                command1(1,0,N-1,index,value,d);
                makeTree(1,0,N-1);
                System.out.println(Arrays.toString(tree));
            }
            else{
                int index1 = Integer.parseInt(comm[1])-1;
                int index2 = Integer.parseInt(comm[2])-1;
                bw.write(command2(1,0,N-1,index1,index2)+"\n");
            }
        }
        bw.flush();

    }
    static void command1(int node,int start, int end, int index,long m,long d){
        if(index<start||index>end)return;
        tree[node]=d==0?tree[node]=tree[node]*m%mod:(tree[node]*m/d)%mod;
        int mid =(start+end)/2;
        if(start!=end){
            command1(node*2,start,mid,index,m,d);
            command1(node*2+1,mid+1,end,index,m,d);
        }
    }
    static long command2(int node, int start, int end, int left, int right){
        if(start>right||left>end)return 1;
        if(start>=left&&right>=end)return tree[node];
        int mid = (start+end)/2;
        return (command2(node*2,start,mid,left,right)*command2(node*2+1,mid+1,end,left,right))%mod;
    }
    static long makeTree(int node,int start,int end){
        if(start==end)return tree[node]=arr[start]%mod;
        int mid = (start+end)/2;
        return tree[node] =(makeTree(node*2,start,mid)*makeTree(node*2+1,mid+1,end))%mod;
    }
}
