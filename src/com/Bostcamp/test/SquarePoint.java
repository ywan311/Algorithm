package com.Bostcamp.test;

public class SquarePoint {
    public int[] solution(int[][] v) {
        int[] answer = new int[2];
        if(v[1][0]==v[0][0])answer[0]=v[2][0];else {
            if(v[2][0]==v[0][0])answer[0]=v[1][0];else answer[0]=v[0][0];
        }
        if(v[1][1]==v[0][1])answer[1]=v[2][1];else {
            if(v[2][1]==v[0][1])answer[1]=v[1][1];else answer[1]=v[0][1];
        }
        return answer;
    }
    public static  void  main(String[] args){
        int[][] v1 ={{1, 4}, {3, 4}, {3, 10}};
        SquarePoint t = new SquarePoint();
        System.out.println(t.solution(v1).toString());

    }
}
