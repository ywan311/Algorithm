package net.Backjun;

import java.io.*;
import java.util.Arrays;

public class P10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        boolean[][] dp = new boolean[N+1][N+1];

        String[] arr = br.readLine().split(" ");

        for(int i =1;i<=N;i++){
            dp[i][i]=true;
        }
        for(int i =1;i<N;i++){
            if(arr[i-1].equals(arr[i])){
                dp[i][i+1]=true;
            }
        }
        for(int i =N;i>=1;i--){
            for(int j=i+2; j<=N;j++){
                if(arr[i-1].equals(arr[j-1]) && dp[i+1][j-1])dp[i][j]=true;
            }
        }

        for(boolean[] a : dp){
            System.out.println(Arrays.toString(a));
        }

        int M = Integer.parseInt(br.readLine());

        while(M-->0){
            String[] input = br.readLine().split(" ");
            bw.write(dp[Integer.parseInt(input[0])][Integer.parseInt(input[1])]?"1":"0");
            bw.write("\n");
        }
        bw.flush();
    }
}
