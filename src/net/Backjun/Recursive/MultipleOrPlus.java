package net.Backjun.Recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MultipleOrPlus {
    static long to;
    static long answer = Long.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        to = Long.parseLong(input[1]);
        answer = Math.min(answer,solution(Long.parseLong(input[0]),1));
        System.out.println(answer==Long.MAX_VALUE?-1:answer);
    }
     static long solution(long n,long index){
        if(n==to) return index;
        if(n>to)return Long.MAX_VALUE;
        return Math.min(solution(n*2,index+1),solution(n*10+1,index+1));
    }
}
