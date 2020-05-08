package net.Programmers;

import java.util.HashSet;
import java.util.Set;

public class Tournament {
    public int solution(int n, int a, int b) {
        int answer = 1;
        int loop = logB(n);

        for(int i=0;i<loop;i++){
            if(a%2==0&&a-1==b)break;
            else if(a%2==1&&a+1==b)break;
            answer++;
            a= next(a);
            b= next(b);
        }

        return answer;
    }

    static int next(int value){
        return (value+1)/2;
    }
    static int logB(double value){
        return (int)(Math.log(value)/Math.log(2));
    }

    public static void main(String[] args) {
        System.out.println(new Tournament().solution(8,4,7));
    }
}
