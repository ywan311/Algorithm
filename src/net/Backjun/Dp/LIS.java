package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LIS {
    static int[] arr;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        br.close();

        arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(str[i]);

        int[] dp = new int[N];

        dp[0]=1;
        for(int i=1;i<N;i++){
            dp[i]=1;
            for(int j=0;j<i;j++) {
                if(arr[i]>arr[j])dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        int max =0;
        for(int i:dp)max = Math.max(i,max);

        System.out.println(max);

    }
}
