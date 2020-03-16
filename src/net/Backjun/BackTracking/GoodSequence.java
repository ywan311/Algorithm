package net.Backjun.BackTracking;

import java.math.BigInteger;
import java.util.Scanner;

public class GoodSequence {
    static int N;
    static String answer ="";
    static char[] arr = new char[]{'1','2','3'};
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        DFS("1",1);
        System.out.println(answer);
    }
    static void DFS(String number, int length){
        System.out.println(number);
        if(answer.length()>0)return;
        if(length==N){
            answer =String.valueOf(number);
            return;
        }
        for(int i=0;i<3;i++){
            if(number.charAt(number.length()-1)!=arr[i]){
                String next = number+arr[i];
                if(check(next))DFS(next,length+1);
            }
        }
    }
    static boolean check(String number){
        if(number.length()<4)return true;
        int length=2;
        while(number.length()/2>=length){
            String tmp = number.substring(number.length()-length);
            String tmp2 = number.substring(number.length()-2*length,number.length()-length);
            if(tmp.equals(tmp2))return false;
            length++;
        }
        return true;
    }
}
