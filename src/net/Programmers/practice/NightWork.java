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
        while (n > 0) {
            works[index]--;
            n--;

            int next = index == 0 ? works.length - 1 : index - 1;
            index = works[index] < works[next]?next:works.length - 1;
        }
        for(int i:works)answer +=Math.pow(i,2);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new NightWork().solution(9, new int[]{1,2,3,4,5,6}));
    }
}
