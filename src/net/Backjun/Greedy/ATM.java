package net.Backjun.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ATM {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(arr);
        int current=0;
        int sum=0;
        for(int i:arr){
            current+=i;
            sum+=current;
        }
        System.out.println(sum);
    }
}
