package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BuyCard {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[1001];
        int dp[] = new int[1001];
        for(int i=0;i<str.length;i++){
            arr[i+1] = Integer.parseInt(str[i]);
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i] = Math.max(dp[i],dp[i-j]+arr[j]);
            }
        }
        System.out.println(dp[n]);
    }
}
