package net.Programmers.practice;

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int  i=citations.length;i>0;i--){
            for (int j=0;j<citations.length;j++){
                if(citations[j]>=i){
                    if(citations.length-j>=i)return answer = i;
                    else break;
                }
            }
        }
        return answer;

//        Arrays.sort(citations);
//
//        int max = 0;
//        for(int i = citations.length-1; i > -1; i--){
//            int min = (int)Math.min(citations[i], citations.length - i);
//            if(max < min) max = min;
//        }
//
//        return max;
    }
    public static void main(String args[]){
        HIndex h = new HIndex();
        int[] a = {3, 0, 6, 1, 5};
        System.out.println(h.solution(a));
    }
}
