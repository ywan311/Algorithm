package net.Programmers.practice;

import java.util.Arrays;

public class RoadToSchool {
    int answer = 0;
    int[][] matrix;
    public int solution(int m, int n, int[][] puddles) {
        matrix = new int[n][m];
        for(int[] arr :puddles){
            matrix[arr[1]-1][arr[0]-1]=-1;
        }
        for(int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }

        findRoute(m-1,n-1);
        return answer;
    }
    public int findRoute(int m,int n){
        System.out.println(m+","+n);
        if(matrix[n][m]==-1){
            return 0;
        }
        else if(matrix[n][m]==0){
            matrix[n][m]=1;
        }
        else if(matrix[n][m]==1){//두갈래 인식 x
            return 1;
        }
        for(int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println(answer);
        if(m==0&&n==0) return 1;
        else if(m==0){
            return answer += findRoute(m,n-1);
        }else if(n==0){
            return answer += findRoute(m-1,n);
        }else{
            return answer +=findRoute(m-1,n) + findRoute(m,n-1);
        }
    }
    public static void main(String[] args){
        System.out.println(new RoadToSchool().solution(4,3,new int[][]{{2,2}}));
    }
}
