package net.Backjun.Dp;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci2 {
    static long[] arr ;
    public static long fibonacci(int n){
        if(arr[n]>0)return arr[n];
        else if(n==0) return 0;
        else if(n==1) return 1;
        else return arr[n]=fibonacci(n-1)+fibonacci(n-2);
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        arr = new long[n+1];
        System.out.println(fibonacci(n));
    }
}
