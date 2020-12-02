package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LISsum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");
        int[] intArr = new int[size+1];
        int[] dp = new int[size+1];

        for(int i=0;i<size;i++){
            intArr[i+1] = Integer.parseInt(arr[i]);
            dp[i+1] = Integer.parseInt(arr[i]);
        }

        dp[1]=intArr[1];

        int answer= dp[1];

        for(int i=1;i<dp.length;i++){
            for(int j= 0;j<i;j++){
                if(intArr[i]>intArr[j]){
                    dp[i] = Math.max(dp[j]+intArr[i],dp[i]);
                    answer = Math.max(dp[i],answer);
                }
            }
        }
        System.out.println(answer);
    }
}
