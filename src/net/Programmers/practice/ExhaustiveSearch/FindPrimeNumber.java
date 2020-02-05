package net.Programmers.practice.ExhaustiveSearch;

import java.util.Arrays;
import java.util.HashSet;

public class FindPrimeNumber {
    static HashSet<Integer> set = new HashSet<>();
    static String[] arr;
    static int answer;

    public int solution(String numbers) {
        answer = 0;
        arr = numbers.split("");

        for (int i = 1; i <= arr.length; i++) {
            System.out.println("legth:"+i);
            for (int j = 0; j < arr.length; j++) {
                boolean visited[] = new boolean[arr.length];
                System.out.println("start:"+j);
                getNumber(visited, j, i, "");
                System.out.println();
            }
        }

        return answer;
    }

    public static void getNumber(boolean[] visited, int start, int length, String result) {
        visited[start] = true;
        result += arr[start];
        System.out.println("current:"+start+"length:"+length+"result:"+result+Arrays.toString(visited));
        if (length == result.length()) {
            if (!set.contains(Integer.parseInt(result))){
                set.add(Integer.parseInt(result));
                if (getPrime(Integer.parseInt(result))) {
                    answer++;
                }
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) getNumber(visited, i, length, result);
        }
    }

    public static boolean getPrime(int num) {
        if (num < 2) return false;

        for (int n = 2; n < num; n++) {
            if (num % n == 0) {
                return false;
            }

        }
        System.out.println(num);
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new FindPrimeNumber().solution("7011"));
    }

}
