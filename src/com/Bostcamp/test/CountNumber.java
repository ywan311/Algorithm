package com.Bostcamp.test;

public class CountNumber {
    public int[] solution(int[] param) {

        int[] cnt = new int[100];
        int answerLength =0;
        int answerIndex=0;
        for( int i =0; i<param.length; i++){
            cnt[param[i]]++;
        }
        for(int i =0; i<cnt.length;i++){
            if(cnt[i]>1){
                answerLength++;
            }
        }
        if(answerLength==0)answerLength=1;
        int[] answer = new int[answerLength];
        for(int i =0; i<cnt.length;i++){
            if(cnt[i]>1){
               answer[answerIndex++]=cnt[i];
            }
        }
        if(answer[0]==0)answer[0]=-1;

        return answer;
    }
    public static void main(String[] args){

        CountNumber t = new CountNumber();
        int[] v = {3,2,4,4,2,5,2,5,5};
        t.solution(v);
    }
}
