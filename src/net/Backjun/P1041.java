package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1041 {
    public static void main(String[] args) throws IOException {
        long size;
        long limit;
        int[] arr = new int[6];
        boolean[] check = new boolean[6];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        limit = (long)Math.pow(N,3);
        if (N >= 3) {
            limit -=Math.pow(N-2,3)+1;
        }
        size = ((long)(Math.pow(N,2)))*5;
        String[] input = br.readLine().split(" ");

        for(int i=0;i<6;i++)arr[i] = Integer.parseInt(input[i]);

        if(N==1){
            Arrays.sort(arr);
            long answer = 0;
            for(int i=0;i<5;i++)answer+=arr[i];
            System.out.println(answer);
            return;
        }
        long minValue=Long.MAX_VALUE;
        int minindex=0;
        for(int i=0;i<6;i++){
            if(arr[i]<minValue){
                minValue=arr[i];
                minindex=i;
            }
        }
        long answer = 0;
        answer +=arr[minindex]*limit;

        check[minindex]=check[5-minindex]=true;
        minValue=Long.MAX_VALUE;
        minindex=0;
        for(int i=0;i<6;i++){
            if(arr[i]<minValue&&!check[i]){
                minValue=arr[i];
                minindex=i;
            }
        }
        size-=limit;
        answer+=arr[minindex]*(size-4);
        check[minindex]=check[5-minindex]=true;
        minValue=Long.MAX_VALUE;
        minindex=0;
        for(int i=0;i<6;i++){
            if(arr[i]<minValue&&!check[i]){
                minValue=arr[i];
                minindex=i;
            }
        }
        answer+=arr[minindex]*4;

        System.out.println(answer);



    }
}
