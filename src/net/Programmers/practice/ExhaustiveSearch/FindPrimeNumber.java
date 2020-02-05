package net.Programmers.practice.Math;

import java.util.Arrays;

public class FindPrimeNumber {
    public int solution(String numbers) {
        int answer = 0;
        char[] result = numbers.toCharArray();
        Arrays.sort(result);
        for(int i=0;i<result.length;i++){
        }
        return answer;
    }
    public static void getPrime(int num) {

        int i = 2; // i : 나눌 대상
        boolean isPrime = true;
        while (i <= num) {
            for (int n = 2; n < i; n++) {
                if (i % n == 0) {
                    isPrime = false;
                    break;
                }
                continue;
            }
            i++;
        }

    }
    public static void main(String[] args){
        new FindPrimeNumber().solution("0012");
    }

}
