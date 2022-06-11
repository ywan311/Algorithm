package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        int left = 0;
        int right = N-1;

        while(left<right){
            int sum = arr[left]+arr[right];
            if(Math.abs(sum) <= Math.abs(min)){
                min = sum;
                answer[0] = arr[left];
                answer[1] = arr[right];
                if(sum==0){
                    break;
                }
            }
            if(sum<0){
                left++;
            }else{
                right--;
            }
        }
        System.out.println(answer[0]+" "+answer[1]);

    }
}
