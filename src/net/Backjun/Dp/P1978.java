package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1978 {
    public static void main(String[] args) throws IOException {
        boolean[] arr = new boolean[1001];
        for(int i=2;i<500;i++){
            for(int j = i+i;j<arr.length;j+=i ){
                arr[j] =true;
            }
        }

        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for(String s: input){
            int value = Integer.parseInt(s);
            if(value>1&&!arr[value])answer++;
        }
        System.out.println(answer);
    }
}
