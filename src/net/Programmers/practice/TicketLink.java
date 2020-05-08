package net.Programmers.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TicketLink {
    static int N;
    static int K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);
        int arr[] = new int[K];
        int input[] = new int[N];

        for(int i=0;i<N;i++){
            input[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(Arrays.toString(input));
        for(int i=0;i<input.length;i++){
            int index=0;
            int min=Integer.MAX_VALUE;
            for(int j=0;j<arr.length;j++){
                if(min>arr[j]){
                    min=arr[j];
                    index=j;
                }
            }
            arr[index]+=input[i];
            System.out.println(Arrays.toString(arr));
        }

        int max =0;
        for(int i:arr)max = Math.max(max,i);
        System.out.println(max);
    }
}
