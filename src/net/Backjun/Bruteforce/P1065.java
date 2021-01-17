package net.Backjun.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1065 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];

        for(int i=1;i<111;i++){
            if(i<100)arr[i]=i;
            else arr[i]=99;
        }
        for(int i=111;i<1001;i++){
            boolean flag=(i/100-i%100/10)==(i%100/10-i%10);
            if(flag)arr[i]=arr[i-1]+1;
            else arr[i]=arr[i-1];
        }
        System.out.println(arr[N]);

    }
}
