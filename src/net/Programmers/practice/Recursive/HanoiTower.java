package net.Programmers.practice.Recursive;

import java.util.Arrays;

public class HanoiTower {
    static int[][] answer;
    static int index=0;
    public int[][] solution(int n) {
        answer = new int[((int)Math.pow(2,n))-1][2];
        move(n,1,2,3);
        return answer;
    }
    static void move(int num,int from, int by, int to){
        if(num==1){
            answer[index++] = new int[]{from,to};
        }else{
            move(num-1,from,to,by);
            answer[index++]= new int[]{from,to};
            move(num-1,by,from,to);
        }
    }

    public static void main(String[] args) {
        int[][]answer = new HanoiTower().solution(4);
        for(int[]a:answer)System.out.println(Arrays.toString(a));
    }
}
