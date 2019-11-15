package net.Programmers.Test;

import java.util.Arrays;

public class MaxValue {
    public String solution(String number, int k) {
        int i=0;
        while(k>0||k==i){
            char[] newNumber= number.toCharArray();
            System.out.println(Arrays.toString(newNumber));
            int n = newNumber[i];
            int m = newNumber[i+1];
            if(n<m){
                if(i==0){
                    number = number.substring(1);
                    k--;
                    continue;
                }else{
                    number = number.substring(0,i)+number.substring(i+1);
                    k--;
                    continue;
                }
            }else{
                i++;
            }
        }
        if(k==0)return number;
        else return number.substring(0,number.length()-k);
    }
    public static void main(String args[]){
        MaxValue m = new MaxValue();
        System.out.println(m.solution("1924",2));
    }
}
