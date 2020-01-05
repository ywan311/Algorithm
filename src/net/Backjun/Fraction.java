package net.Backjun;

import java.util.Scanner;

public class Fraction {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int n  = input.nextInt();
        int sum =0;
        int i=1;
        while(true){
            if(n<=sum+i)break;
            else {
                sum +=i;
                i++;
            }
        }
        int tmp = n-sum;
        if(i%2==0)System.out.println(tmp+"/"+(i-tmp+1));
        else System.out.println(i-tmp+1+"/"+tmp);
    }
}
