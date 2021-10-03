package net.Programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InAndOut {
    public int[] solution(int[] enter, int[] leave) {
//        int[] answer = new int[enter.length];
//        Set<Integer> set = new HashSet<>();
//
//        for(int i : leave){
//            for(int j : enter){
//                    if(i==j)break;
//                    if(!set.contains(j)){
//                        answer[j-1]++;
//                    }
//            }
//            set.add(i);
//        }
//        System.out.println(Arrays.toString(answer));;
//        return answer;
    }

    public static void main(String[] args) {
        new InAndOut().solution(new int[]{1,3,2},new int[]{1,2,3});
    }
}
