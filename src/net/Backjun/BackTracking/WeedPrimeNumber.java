package net.Backjun.BackTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class WeedPrimeNumber {
    static int[] prime = new int[]{1,2,3,5,7,9};
    static ArrayList<Integer> answer = new ArrayList<>();
    static int N;
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        N = input.nextInt();
        for(int i=1;i<prime.length-1;i++){
            DFS(1,prime[i]);
        }
        for(int i:answer)System.out.println(i);
    }
    static void DFS(int length, int number){
        if(length==N){
            answer.add(number);
            return;
        }
        for(int i=0;i<prime.length;i++){
            int next = number*10+prime[i];
            if(check(next))DFS(length+1, next);
        }

    }
    static boolean check(int number){
        int n=2;
        while(n<number){
            if(number%n==0)return false;
            n++;
        }
        return true;
    }
}
