package net.Backjun;

import java.io.*;
import java.util.Arrays;

public class P12852 {
    static int N;
    static int[] arr = new int[1000001];
    static int[] path = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[0]=arr[1]=0;

        for(int i =2;i<=N;i++){
            if(i%3==0 && arr[i/3]+1<arr[i]){
                arr[i]=arr[i/3]+1;
                path[i]=i/3;
            }
            if(i%2==0 && arr[i/2]+1<arr[i]){
                arr[i]=arr[i/2]+1;
                path[i]=i/2;
            }
            if(arr[i-1]+1<arr[i]){
                arr[i]=arr[i-1]+1;
                path[i]=i-1;
            }
        }

        bw.write(String.valueOf(arr[N]));
        bw.write("\n");

        while(N>0){
            bw.write(N+" ");
            N=path[N];
        }
        bw.flush();

    }
}
