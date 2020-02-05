package net.Programmers.practice.Math;

import java.util.Arrays;

public class MultipleMatrix {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i=0;i<answer.length;i++){
            for(int j=0;j<answer[0].length;j++){
                int sum=0;
                for(int k=0;k<arr2.length;k++){
                    sum+= arr1[i][k]*arr2[k][j];
                }
                answer[i][j]=sum;
            }
        }
        for(int[] a:answer)System.out.println(Arrays.toString(a));
        return answer;
    }

    public static void main(String[] args) {
        new MultipleMatrix().solution(new int[][]{{1,4},{3,2},{4,1}}, new int[][]{{3,3},{3,3}});
    }
}
