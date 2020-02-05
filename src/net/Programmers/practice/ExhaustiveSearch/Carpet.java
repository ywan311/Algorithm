package net.Programmers.practice.ExhaustiveSearch;

import java.util.Arrays;

public class Carpet {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];

        for(int i=1;i<=red;i++){
            if(red%i==0){
                int width = red/i;
                if((width+2)*(i+2)==brown+red){
                    answer[0]=width+2;
                    answer[1]=i+2;
                    break;
                }else continue;
            }else continue;
        }
        return answer;
    }
    public static  void main(String args[]){
        Carpet carpet = new Carpet();
        System.out.println(Arrays.toString(carpet.solution(8,1)));
    }
}
