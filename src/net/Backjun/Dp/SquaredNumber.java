package net.Backjun.Dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SquaredNumber {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        int n = input.nextInt();

        int arr[] = new int[100001];
        arr[1]=1;
        for(int i=2;i<=100000;i++){
            arr[i] =i;
            for(int j=1;j*j<=i;j++){
                arr[i] = Math.min(arr[i],arr[i-j*j]+1);
            }
        }
        System.out.println(arr[n]);

    }
}
