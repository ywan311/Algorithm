package net.Backjun.Greedy;

import java.util.Scanner;

public class Tile01 {
    static int[] arr ;
    public static int fibonacci(int n){
        if(arr[n]>0)return arr[n];
        else if(n==0) return 0;
        else if(n==1) return 1;
        else if(n==2) return 2;
        else return arr[n]=fibonacci(n-1)%15746+fibonacci(n-2)%15746;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        arr = new int[n+1];
        System.out.println(fibonacci(n)%15746);
    }
}
