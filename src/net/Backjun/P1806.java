package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        Integer[] arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        int start = 0;
        int end = 0;
        int answer = Integer.MAX_VALUE;
        int sum = arr[start];

        while(start <= end){
            if(sum>=S){
                answer = Math.min(answer,end-start);
                sum-=arr[start];
                start++;
            }else if(end < N-1){
                end++;
                sum+=arr[end];
            }else {
                break;
            }
        }
        System.out.println(answer==Integer.MAX_VALUE?0:answer+1);
    }
}
