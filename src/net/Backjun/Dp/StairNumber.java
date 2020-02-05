package net.Backjun.Dp;

import java.util.Scanner;

public class StairNumber {
    static long[][] arr = new long[100][9];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i=0;i<9;i++){
            arr[0][i]=1;
            if(i==8)arr[1][i]=1;
            else arr[1][i]=2;
        }
        if(n>2){
            for(int i=2;i<n;i++){
                for(int j=0;j<9;j++){
                    if(j==0)arr[i][j]=(arr[i-2][j]+arr[i-1][j+1])%1000000000;
                    else if(j==8)arr[i][j]=(arr[i-2][j]+arr[i-1][j-1])%1000000000;
                    else arr[i][j] = (arr[i-1][j-1]+arr[i-1][j+1])%1000000000;
                }
            }
        }
        long result = 0;
        for(int i=0;i<9;i++){
            result += arr[n-1][i];
        }
        System.out.println(result%1000000000);

    }
}
