package net.Backjun.Dp;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class WaveSeqence {
    static long dp[] = new long[100];
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int loop = input.nextInt();
        dp[0] =1;
        dp[1] =1;
        dp[2] =1;
        dp[3] =2;
        dp[4] =2;
        for(int i=5;i<100;i++){
            dp[i] = dp[i-1]+dp[i-5];
        }

        for(int i=0;i<loop;i++){
            int n = input.nextInt();
            bw.write(dp[n-1]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
