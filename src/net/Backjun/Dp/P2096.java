package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2096 {
    static int[][] arr;
    static int[][] dpMax;
    static int[][] dpMin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][3];
        dpMax = new int[N][3];
        dpMin = new int[N][3];

        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");

            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
            arr[i][2] = Integer.parseInt(input[2]);
        }

        dpMax[0] = arr[0];
        dpMin[0] = arr[0];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=1;i<arr.length;i++){
            dpMax[i][0] = arr[i][0]+Math.max(dpMax[i-1][0],dpMax[i-1][1]);
            dpMax[i][1] = arr[i][1]+Math.max(dpMax[i-1][0],Math.max(dpMax[i-1][2],dpMax[i-1][1]));
            dpMax[i][2] = arr[i][2]+Math.max(dpMax[i-1][2],dpMax[i-1][1]);


            dpMin[i][0] = arr[i][0]+Math.min(dpMin[i-1][0],dpMin[i-1][1]);
            dpMin[i][1] = arr[i][1]+Math.min(dpMin[i-1][0],Math.min(dpMin[i-1][2],dpMin[i-1][1]));
            dpMin[i][2] = arr[i][2]+Math.min(dpMin[i-1][2],dpMin[i-1][1]);

        }

        for(int i: dpMax[N-1])max = Math.max(max,i);
        for(int i: dpMin[N-1])min = Math.min(min,i);

        System.out.println(max+" "+min);

    }
}
