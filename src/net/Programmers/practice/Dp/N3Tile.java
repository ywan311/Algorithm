package net.Programmers.practice.Dp;

public class N3Tile {
    public int solution(int n) {
        int answer = 0;
        int mod = 1000000007;
        long[] dp = new long[5001];
        dp[0]=1;
        dp[2]=3;
        for(int i=4;i<dp.length;i+=2){
            for(int j=2;j<=i;j+=2){
                int tmp = j==2?3:2;
                dp[i]+=dp[i-j]*tmp;
            }
            dp[i]%=mod;
        }
        return (int)(dp[n]%mod);
    }

    public static void main(String[] args) {
        System.out.println(new N3Tile().solution(5000));
    }
}
