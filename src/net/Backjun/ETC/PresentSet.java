package net.Backjun.ETC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PresentSet {
    static int[] arr;
    static int N;
    static int M;
    static String[] answer = new String[]{"YES","NO"};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");

        N =Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);


        arr = new int[N+1];

        for(int i=0;i<N+1;i++){
            arr[i]=i;
        }
        for(int i=0;i<M;i++){
            String[] command = br.readLine().split(" ");
            if(Integer.parseInt(command[0])==0)case0(Integer.parseInt(command[1]),Integer.parseInt(command[2]));
            else if(Integer.parseInt(command[0])==1)bw.write(case1(Integer.parseInt(command[1]),Integer.parseInt(command[2]))+"\n");
        }

        bw.flush();

    }
    static void case0(int a, int b){
        merge(a,b);
    }
    static int find(int a){
        if(a==arr[a])return a;
        return arr[a] =find(arr[a]);
    }
    static void merge(int a,int b){
        a= find(a);
        b= find(b);

        if(a==b)return;

        arr[a] =b;
    }
    static String case1(int a, int b){
        a=find(a);
        b= find(b);
        return a==b?answer[0]:answer[1];
    }
}
