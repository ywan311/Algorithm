package net.Programmers;

import java.util.Arrays;

public class MaxValue {
    public long solution(String expression) {
        long answer = 0;
        String[] arr = expression.split("[*+-]");
        String[] arr2 = expression.split("[0-9]");
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new MaxValue().solution("100-200*300-500+20"));
    }
}
