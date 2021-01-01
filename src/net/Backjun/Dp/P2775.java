package net.Backjun.Dp;

import java.util.Arrays;
import java.util.Scanner;

public class P2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[15][14];



        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(i==0)arr[i][j]=j+1;
                else if(j==0)arr[i][j]=1;
                else arr[i][j]= arr[i-1][j]+arr[i][j-1];
            }
        }

        int T = sc.nextInt();
        while(T-->0){
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(arr[k][n-1]);
        }
    }
}
