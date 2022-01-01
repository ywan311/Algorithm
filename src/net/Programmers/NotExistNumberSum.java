package net.Programmers;

import java.util.Arrays;

public class NotExistNumberSum {
    public int solution(int[] numbers) {
        return 45-Arrays.stream(numbers).sum();
    }

    public static void main(String[] args) {

    }
}
