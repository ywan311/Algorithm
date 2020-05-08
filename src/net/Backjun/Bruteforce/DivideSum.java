package net.Backjun.Bruteforce;

import java.util.Scanner;

public class DivideSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n= input.nextInt();
        int answer = n;

        for(int i=n;i>0;i--){
            int tmp =i;
            int value = i;
            while(value>0){
                tmp += value%10;
                value /=10;
            }
            if(n==tmp)answer = Math.min(answer,i);
        }
        if(answer==n)answer=0;
        System.out.println(answer);
    }
}
