package net.Programmers.practice.Dp;

public class N2Tile {
    static long[] dp;
    public int solution(int n) {
        int answer = 0;
        dp = new long[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%1000000007;
        }

        return (int)dp[n]%1000000007;
    }
    public static void main(String[] args) {

    }
}
