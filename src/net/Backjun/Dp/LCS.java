package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LCS {
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        String answer = "";

        dp = new int[s1.length()+1][s2.length()+1];

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int pivot =dp[s1.length()][s2.length()];
        for(int i=s1.length();i>0;i--){
            for(int j=s2.length();j>0;j--){
                int tmp =dp[i][j];

                if(pivot!=tmp)continue;
                if(tmp>dp[i-1][j]&&tmp>dp[i][j-1]&&tmp>dp[i-1][j-1]){
                    answer =s1.charAt(i-1)+answer;
                    pivot--;
                    break;
                }
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
        System.out.println(answer);
    }
}
