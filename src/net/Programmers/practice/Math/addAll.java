package net.Programmers.practice.Math;

public class addAll {
    public boolean solution(int n) {
        int x = n;
        int sum = 0;
        while(n>0){
            sum += n%10;
            n/=10;
        }
        return x%sum==0?true:false;
    }
    public static void main(String[] args){
        System.out.println(new addAll().solution(123));
    }
}
