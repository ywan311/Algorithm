package net.Backjun.Dp;

import java.util.Scanner;

public class FillTiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int arr[] = new int[31];
        arr[0]=1;
        arr[2]=3;
        for(int i=4;i<arr.length;i+=2){
            for(int j=2;j<=i;j+=2){
                int n = j==2?3:2;
                arr[i]+=n*arr[i-j];
            }
        }
        System.out.println(arr[N]);
    }
}
