package net.Programmers.practice.Dp;


import java.util.Arrays;

public class MaxSet {
    public int[] solution(int n, int s) {
        if(n>s)return new int[]{-1};
        int[] answer =new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            answer[i]=s/n;
            sum+=answer[i];
        }
        if(sum<s){
            for (int i=answer.length-1;i>0&&sum<s;i--){
                answer[i]++;
                sum++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaxSet().solution(5,9)));
    }
}
