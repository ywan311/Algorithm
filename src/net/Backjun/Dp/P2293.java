package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2293 {
    static int[] dp = new int[10001];
    static int coin[] = new int[101];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        dp[0]=1;
        for(int i=1;i<=N;i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1;i<=N;i++){
            for(int j=coin[i];j<=M;j++){
                dp[j] += dp[j - coin[i]];
                System.out.println(i+":"+j+"=="+dp[j]);
            }
        }
            System.out.print(dp[M]);
    }
}
