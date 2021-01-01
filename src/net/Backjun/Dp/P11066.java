package net.Backjun.Dp;

import java.io.*;
import java.util.Arrays;

public class P11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        while(n-->0){
            int size = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(solve(size,br.readLine())));
            bw.write("\n");
        }
        bw.flush();

    }
    private static int solve(int size,String arrString){
        String[] input = arrString.split(" ");
        int[] arr = new int[size];
        int[] dp = new int[size+1];
        for(int i=0;i<size;i++){
            arr[i] =Integer.parseInt( input[i]);
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
   System.out.println(Arrays.toString(arr));

        dp[0]=0;
        dp[1] = arr[0];
        
        dp[2] = arr[0]+arr[1];
        for(int i=3;i<size+1;i++){
            dp[i] = Math.min(dp[i-1]*2+arr[i-1],(arr[i-1]+arr[i-2])*2+dp[i-2]*2);
        }
        System.out.println(Arrays.toString(dp));
        return dp[size];
    }
}
