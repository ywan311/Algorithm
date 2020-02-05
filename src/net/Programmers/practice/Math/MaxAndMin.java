package net.Programmers.practice.Math;

import net.Programmers.practice.Dp.MakeN;

public class MaxAndMin {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] str = s.split(" ");
        int max=Integer.MAX_VALUE*-1;
        int min = Integer.MAX_VALUE;
        for(String tmp:str){
            max = Math.max(max,Integer.parseInt(tmp));
            min = Math.min(min,Integer.parseInt(tmp));
        }
        answer.append(min+" ");
        answer.append(max);
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MaxAndMin().solution("-1 -2 -3 -4"));
    }
}
