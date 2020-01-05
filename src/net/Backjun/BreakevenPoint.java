package net.Backjun;

import java.util.Scanner;

public class BreakevenPoint {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        if(b<=c)System.out.println(-1);
        else System.out.println(a/(b-c)+1);
    }
}
