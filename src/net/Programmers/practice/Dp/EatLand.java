package net.Programmers.practice.Dp;

import java.util.Arrays;

public class EatLand {
    int solution(int[][] land) {
        int answer=0;
        for(int i=1;i<land.length;i++){
            land[i][0] += Math.max(land[i-1][1],Math.max(land[i-1][2],land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0],Math.max(land[i-1][2],land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][2]));
        }
        for(int i:land[land.length-1])answer= Math.max(answer,i);

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new EatLand().solution(new int[][]{
                {1,2,3,5}
                ,{5,6,7,8}
                ,{4,3,2,1}
        }));
    }

}
