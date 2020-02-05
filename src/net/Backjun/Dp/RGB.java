package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RGB {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][3];

        for(int i=0;i<N;i++){
            String s[] = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
            arr[i][2] = Integer.parseInt(s[2]);
        }
        for(int i=1;i<N;i++){
            arr[i][0] += Math.min(arr[i-1][1],arr[i-1][2]);
            arr[i][1] += Math.min(arr[i-1][0],arr[i-1][2]);
            arr[i][2] += Math.min(arr[i-1][0],arr[i-1][1]);
        }
        System.out.println(Math.min(Math.min(arr[N-1][0],arr[N-1][1]),arr[N-1][2]));

    }
}
