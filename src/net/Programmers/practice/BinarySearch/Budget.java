package net.Programmers.practice.BinarySearch;

import java.util.Arrays;

public class Budget {
    public int solution(int[] budgets, int M) {
        long answer = M/budgets.length;
        Arrays.sort(budgets);
        long sum=0;
        for(int a:budgets)sum+=a;
        if(sum<=M)return budgets[budgets.length-1];
        long left =budgets[0];
        long right = budgets[budgets.length-1];
        long mid;

        while(left<=right){
            sum=0;
            mid = (left+right)/2;
            for(int a:budgets)
                sum+= a>mid?mid:a;
            if(sum>M){
                right = mid -1;
            }else{
                answer = Math.max(answer,mid);
                left = mid+1;
            }
        }
        return (int)answer;
    }

    public static void main(String[] args) {
        System.out.println(new Budget().solution(new int[]{120,110,140,150},485));
    }
}
