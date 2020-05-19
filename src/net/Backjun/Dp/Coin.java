package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Coin {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] arr = new int[n+1];
        int index=1;
        while(n-->0){
            arr[index++]=Integer.parseInt(br.readLine());
        }

        int dp[] = new int[k+1];
        Arrays.fill(dp,100001);
        dp[0]=0;

        for(int i=1;i<arr.length;i++){
            for(int j=arr[i];j<=k;j++){
                dp[j] = Math.min(dp[j],dp[j-arr[i]]+1);
            }
        }
        System.out.println(dp[k]==100001?-1:dp[k]);
    }
}
