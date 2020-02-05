package net.Backjun.Search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    static int arr[];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        arr = new int[length];
        for(int i=0;i<length;i++){
            arr[i] = input.nextInt();
        }
        Arrays.sort(arr);

        int answerLength = input.nextInt();
        for(int i=0;i<answerLength;i++){
            int target = input.nextInt();
            System.out.println(findNumber(target, 0,arr.length-1));
        }


    }
    public static int findNumber(int n,int start,int end){
        int middle = (start+end)/2;
        int value = arr[middle];
        if(value==n)return 1;
        else if(start<=end)return 0;
        else if(value>n)return findNumber(n, start, middle-1);
        else return findNumber(n,middle+1, end);
    }
}
