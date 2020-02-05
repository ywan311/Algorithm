package net.Backjun.Dp;

public class Fibonacci {
    static int[] arr ;
    public int solution(int n) {
        arr = new int[n+1];


        return fibonacci(n);
    }
    public static int fibonacci(int n){
        if(arr[n]>0)return arr[n]%1234567;
        else if(n==0) return 0%1234567;
        else if(n==1) return 1%1234567;
        else return arr[n]=fibonacci(n-1)%1234567+fibonacci(n-2)%1234567;
    }
    public static void main(String[] args){
        System.out.println(new Fibonacci().solution(5));
    }
}
