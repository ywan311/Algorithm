package net.Programmers.practice;

public class SumTwoInteger {
    public long solution(int a, int b) {
        long answer = 0;
        int big = Math.max(a,b);
        int small = Math.min(a,b);
        for(int i = small;i<=big;i++){
            answer += i;
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(new SumTwoInteger().solution(-1000,1000));
    }
}
