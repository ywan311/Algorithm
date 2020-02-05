package net.Programmers.practice.Math;

import java.util.Arrays;

public class FailRatio {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] failure = new double[N];
        for(int i=0;i<failure.length;i++){
            double fail=0;
            double success=0;
            for(int j =0;j<stages.length;j++){
                if(stages[j]==i+1)fail++;
                if(stages[j]>=i+1)success++;
            }
            failure[i]= success==0?0:fail/success;
        }
        for(int i=0;i<answer.length;i++){//hashmap 이용시 logn 번 덜돌수있음(최대값을 하나씩 삭제하기 때문)
            int index=0;
            double max = -1.0;
            for(int j=0;j<failure.length;j++){
                if(max<failure[j]){
                    index=j;
                    max = failure[j];
                }
            }
            failure[index]=-1;
            answer[i]=index+1;
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(new FailRatio().solution(5,new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
    }
}
