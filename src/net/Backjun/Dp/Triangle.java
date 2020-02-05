package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Triangle {
    static int N;
    static int arr[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N*(N+1)/2];
        int answer[] = new int[N*(N+1)/2];
        int index=0;
        while(index<arr.length){
            String str[] = br.readLine().split(" ");
            for(String s:str)arr[index++]= Integer.parseInt(s);
        }
        answer[0] = arr[0];
        index =0;
        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                answer[index+i]= Math.max(answer[index+i],answer[index]+arr[index+i]);
                answer[index+i+1]= Math.max(answer[index+i+1],answer[index]+arr[index+i+1]);
                index++;
            }
        }

        int max =0;
        for(int i=1;i<=N;i++){
            max =Math.max(max,answer[arr.length-i]);
        }
        System.out.println(max);

    }
}
