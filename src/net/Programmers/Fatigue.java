package net.Programmers;

import java.util.Arrays;

public class Fatigue {
    static boolean[] check;
    static int[][] staticDungeons;
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        staticDungeons = Arrays.copyOf(dungeons,dungeons.length);
         raid(k,0);

        return answer;
    }

    void raid(int currentFatigue,int count){
        for(int i =0;i< staticDungeons.length;i++){
            if(check[i] || staticDungeons[i][0]>currentFatigue){
                continue;
            }
            check[i]=true;
            raid(currentFatigue-staticDungeons[i][1],count+1);
            check[i]=false;
        }
        answer = Math.max(answer,count);
    }

    public static void main(String[] args) {
        System.out.println(new Fatigue().solution(80	,new int[][]{{80,20},{50,40},{30,10}}));
    }
}
