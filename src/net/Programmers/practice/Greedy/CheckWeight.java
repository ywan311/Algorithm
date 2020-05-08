package net.Programmers.practice.Greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckWeight {
    public int solution(int[] weight) {
        Arrays.sort(weight);
        int sum = weight[0];
        for(int i=1;i<weight.length;i++){
            if(sum+1>=weight[i]){
                sum+=weight[i];
            }else {
                break;
            }
        }
        return sum+1;
    }
    public static void main(String[] args) {
//        System.out.println(new CheckWeight().solution(new int[]{3, 1, 6, 2, 7, 30, 1}));
        int a=5;
        int b=3;
        for(;b>0;b--){
            for(int j=0;j<a;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
