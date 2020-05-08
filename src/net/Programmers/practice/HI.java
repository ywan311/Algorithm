package net.Programmers.practice;

import java.util.Arrays;

public class HI {
    public int solution(int[] budgets, int M) {
        long answer = M/budgets.length;
        long sum = 0;
        Arrays.sort(budgets);
        for (int i : budgets) sum += i;
        if (sum <= M) return budgets[budgets.length - 1];//합이 예산보다 크면 끝

        long left = budgets[0];
        long right = budgets[budgets.length - 1];
        long mid;
        while (left <= right) {
            mid = (left + right) / 2;
            sum = 0;
            for (int i : budgets) {
                if (mid < i) sum += mid;
                else sum += i;
            }
            if (sum > M) right = mid - 1;
            else {
                answer = Math.max(answer, mid);
                left = mid + 1;
            }
        }
        return (int) answer;
    }

    public static void main(String[] args) {
        int[] input = new int[100000];
        for(int i=0;i<100000;i++){
            input[i]=100000;
        }
        System.out.println(new HI().solution(input, 1000000000 ));
    }
}
