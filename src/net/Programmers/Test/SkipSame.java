package net.Programmers.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class SkipSame {
    public int[] solution(int []arr) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        int tmp =0 ;
        for(int i : arr){
            if(arrayList.isEmpty()||tmp!=i){
                arrayList.add(i);
                tmp=i;
            }
        }

        int[] answer = new int[arrayList.size()];
        for(int i=0;i<arrayList.size() ;i++){
            answer[i] = arrayList.get(i);
        }
        return answer;
    }
}
