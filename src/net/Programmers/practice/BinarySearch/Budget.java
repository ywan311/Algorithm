package net.Programmers.practice.BinarySearch;

import java.util.Arrays;

public class Budget {
    public int solution(int[] budgets, int M) {
        long answer = M/budgets.length;
        Arrays.sort(budgets);
        long sum=0;
        for(int i=0;i<budgets.length;i++){
            sum+=budgets[i];
        }
        if(sum<=M)return budgets[budgets.length-1];

        long sum2=0;
        for(int i=0;i<budgets.length;i++){
            sum2+=budgets[i];
            long tmp =i<budgets.length-1?(M-sum2)/(budgets.length-i-1):0;
            if(answer<tmp){
                answer= tmp;
            }
        }
        return (int)answer;
    }

    public static void main(String[] args) {
        System.out.println(new Budget().solution(new int[]{120,110,140,150},485));
    }
}
