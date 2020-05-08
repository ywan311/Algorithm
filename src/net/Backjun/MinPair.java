package net.Backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//세그먼트 트리 개어려움 공부 ㄱㄱ
//미완성

public class MinPair {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String length[] = br.readLine().split(" ");
        int N = Integer.parseInt(length[0]);
        int M = Integer.parseInt(length[1]);
        int arr[] = new int[N];
        ArrayList<Integer>[] dp = (ArrayList<Integer>[]) new ArrayList[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0;i<N;i++){
            int min = arr[i];
            dp[i] = new ArrayList<>();
            for(int j=i;j<N;j++){
                min= Math.min(min,arr[j]);
                dp[i].add(min);
            }
        }


        while(M-->0){
            String pair[] = br.readLine().split(" ");
            int start = Integer.parseInt(pair[0])-1;
            int end = Integer.parseInt(pair[1])-1;

            bw.write(dp[start].get(end-start)+"\n");
        }
        bw.flush();
    }
}
