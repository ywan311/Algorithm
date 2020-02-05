package net.Programmers.practice.Math;

import java.util.ArrayList;
import java.util.Arrays;

public class DivisionArray {
    public int[] solution(int[] arr, int divisor) {
        Arrays.sort(arr);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i :arr){
            if(i%divisor==0)arrayList.add(i);
        }
        if(arrayList.size()==0)return new int[] {-1};
        else{
            int[] answer = new int[arrayList.size()];
            for(int i =0;i<arrayList.size();i++){
                answer[i] = arrayList.get(i);
            }
            return answer;
        }
    }
    public static void main(String[] args){
        System.out.println(new DivisionArray().solution(new int[] {2, 36, 1, 3},5));
    }
}
