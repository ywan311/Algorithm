package net.Backjun.Math;

import java.util.Scanner;

public class Multiply {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long a = input.nextInt();
        long b = input.nextInt();
        long c = input.nextInt();
        long answer = 1;
        long tmp=a%c;

        for(;b>0;b/=2){
            if(b%2==1)answer = answer*tmp%c;
            tmp = ((tmp%c)*(tmp%c))%c;
        }
        System.out.println(answer);

    }
}
