package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SessionSum5 {
    static int arr[][];
    static int N;
    static int M;
    static int dp[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        arr = new int[N][N];
        dp = new int[N+1][N+1];
        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                arr[i][j]= Integer.parseInt(input[j]) ;
                dp[i+1][j+1]= dp[i+1][j]+dp[i][j+1]-dp[i][j]+arr[i][j];
            }
        }
        for(int[] a: dp)System.out.println(Arrays.toString(a));
        for(int i=0;i<M;i++){
            String input[] = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);
            int result = dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][x2-1];
            bw.write(result+"\n");
        }
        bw.flush();

    }
}
