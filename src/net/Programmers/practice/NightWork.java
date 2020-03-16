package net.Programmers.practice;

import java.util.Arrays;

//미완성
public class NightWork {
    public long solution(int n, int[] works) {
        long answer = 0;
        Arrays.sort(works);
        int index = works.length - 1;
        int sum = 0;
        for (int i : works) sum += i;
        if(sum<=n)return 0;
        int avg = sum / works.length;
        boolean flag=false;
        while (n > 0) {
            works[index]--;
            n--;

            int next = index == 0 ? works.length - 1 : index - 1;
            if (works[index] < works[next]) index = next;
        }
        for(int i:works)answer +=Math.pow(i,2);
        return answer;
    }

    public static void main(String[] args) {
        int[] input = new int[2000];
        for (int i = 0; i < input.length; i++) {
            input[i] = 50000;
        }
        System.out.println(new NightWork().solution(4, new int[]{1,9}));
    }
}
