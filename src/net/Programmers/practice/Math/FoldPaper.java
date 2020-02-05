package net.Programmers.practice.Math;

import java.util.Arrays;

public class FoldPaper {
    public int[] solution(int n) {
        int[] answer = new int[(int)Math.pow(2,n)-1];
        int pivot =1;
        int index=1;
        for(int i=0;i<answer.length;i++){
            if(i==pivot-1){
                answer[i]=0;
                pivot*=2;
                index=1;
            }else{
                answer[i] = answer[pivot/2-1-index++]==0?1:0;
            }

        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(new FoldPaper().solution(2)));
    }
}
