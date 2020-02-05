package net.Programmers.practice.Dp;

import java.util.Arrays;

public class Tile {
    static long[] arr;
    public long solution(int N) {
        arr = new long[N+1];

        arr[0]=1;
        arr[1]=1;

        for(int i=2;i<N+1;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }

        return 2*arr[N]+2*arr[N-1];
    }
    public static void main(String[] args) {
        System.out.println(new Tile().solution(5));
    }
}
