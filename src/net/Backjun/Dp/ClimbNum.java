package net.Backjun.Dp;

import java.util.Scanner;

public class ClimbNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        long[][] dp = new long[10][1001];
        for(int i=0;i<10;i++)dp[i][1]=1;
        for(int i=2;i<1001;i++){
            for(int j=0;j<10;j++){
                for(int k=j;k<10;k++){
                    dp[j][i]+=dp[k][i-1];
                    dp[j][i]%=10007;
                }
            }
        }
        int answer=0;
        for(int i=0;i<10;i++){
            answer+=dp[i][n];
        }
        System.out.println(answer%10007);
    }
}
