package net.Programmers.practice.Greedy;

import java.util.*;

public class Camera {

    public int solution(int[][] routes) {
        int answer = 0;
        int min = Integer.MIN_VALUE;
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1], b[1]));
        for(int[] a:routes)System.out.println(Arrays.toString(a));

        for(int[] route : routes) {
            if(min < route[0]) {
                min = route[1];
                answer++;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Camera().solution(new int[][]{{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}}));
    }
}
