package net.Backjun.Dp;

import java.util.Arrays;
import java.util.Scanner;

public class Wine {
    static int [] arr;
    static int[] answer;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n= input.nextInt();
        arr = new int[n];
        answer = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = input.nextInt();
        }
        answer[0]= arr[0];
        if(n>1)answer[1] = arr[1]+arr[0];
        if(n>2)answer[2] = Math.max(answer[1], Math.max(answer[0]+arr[2],arr[1]+arr[2]));

        for(int i=3;i<n;i++){
            answer[i] = Math.max(answer[i-1],Math.max(answer[i-2]+arr[i],answer[i-3]+arr[i-1]+arr[i]));
        }
        System.out.println(answer[n-1]);

    }
}
