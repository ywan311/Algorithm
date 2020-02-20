package net.Programmers.practice.ExhaustiveSearch;

import java.util.*;

public class NumberBaseball {
    static Set<Integer> set = new HashSet<>();
    static Queue<int[]> input= new LinkedList<>();
    public int solution(int[][] baseball) {
        int answer = 0;
        for(int i=0;i<9;i++)set.add(i+1);

        for(int[] a:baseball)input.offer(new int[]{a[0],a[1],a[2]});
        for(int a[]:input)System.out.println(Arrays.toString(a));

        return answer;
    }
    static void strike(String str,int strike, int ball){

        for(int i=0;i<3;i++){
            if(str.charAt(i)==0&&strike>0){

            }
        }
    }
    static void ball(){

    }

    public static void main(String[] args) {
        System.out.println(new NumberBaseball().solution(new int[][]{{123,1,1},{356,1,0},{327,2,0},{489,0,1}}));
    }
}
