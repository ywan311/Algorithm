package net.Backjun.Dp;

import java.util.Scanner;

public class Fibonacci3 {
    static int[][] arr ;
    public static int[] fibonacci(int n){
        if(arr[n][0]>0&&arr[n][1]>0)return arr[n];
        else if(n==0) return arr[0] = new int[]{1,0};
        else if(n==1) return arr[1] = new int[]{0,1};
        else {
            int[] a =fibonacci(n-1);
            int[] b = fibonacci(n-2);
            arr[n][0] = a[0]+b[0];
            arr[n][1] = a[1]+b[1];
            return arr[n];
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i=0;i<n;i++){
            int value = input.nextInt();
            arr = new int[value+1][2];
            fibonacci(value);
            for(int tmp:arr[value])System.out.print(tmp+" ");
            System.out.println();
        }
    }
}
