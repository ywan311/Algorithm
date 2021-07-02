package net.Backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P3273 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int pivot = Integer.parseInt(br.readLine());

        int answer = 0;

        int left = 0;
        int right = size-1;

        Arrays.sort(arr);

        while(left<right){
            int sum = arr[left]+arr[right];

            if(sum==pivot){
                answer ++;
                right--;
                left++;
            }else if(sum<pivot) {
                left++;
            }else{
                right--;
            }
        }
        System.out.println(answer);

    }
}
