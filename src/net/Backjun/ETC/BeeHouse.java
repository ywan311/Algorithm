package net.Backjun;

import java.util.Scanner;

public class BeeHouse {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int sum =1;
        int i=1;
        while(true){
            if(n<=sum)break;
            else {
                sum +=i*6;
                i++;
            }
        }
        System.out.println(i);
    }
}
