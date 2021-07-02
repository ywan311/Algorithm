package net.Programmers.practice;

import java.util.Arrays;

public class Lotto {
        public int[] solution(int[] lottos, int[] win_nums) {

            int cntZero = 0;
            int cntMatch = 0;

            int[] result = new int[]{6,6,5,4,3,2,1};

            for(int a : lottos){
                if(a==0){
                    cntZero++;
                }else{
                    for(int b : win_nums){
                        if(a==b){
                            cntMatch++;
                        }
                    }
                }
            }
            return new int[]{result[cntMatch+cntZero],result[cntMatch]};
    }

    public static void main(String[] args) {
            int[] a = {45, 4, 35, 20, 3, 9};
            int[] b = {20, 9, 3, 45, 4, 35};
        System.out.println(Arrays.toString(new Lotto().solution(a,b)));
    }
}
