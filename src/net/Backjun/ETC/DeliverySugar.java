package net.Backjun.ETC;

import java.util.Scanner;

public class DeliverySugar {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int kg = input.nextInt();
        int a = kg/5;
        int answer =-1;
        if((kg-a*5)%3==0)System.out.println(a+(kg-a*5)/3);
        else{
            for(int i = a-1; i>=0; i--){
                if((kg-i*5)%3==0){
                  answer =i+(kg-i*5)/3;
                  break;
                }
            }
            System.out.println(answer);
        }

    }
}
