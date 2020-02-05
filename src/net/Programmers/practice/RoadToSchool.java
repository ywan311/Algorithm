package net.Programmers.practice;

import java.util.Arrays;

public class RoadToSchool {
    int[][] matrix;
    public int solution(int m, int n, int[][] puddles) {
        matrix = new int[n+1][m+1];
        if(puddles[0].length>0){
            for(int[] arr :puddles){
                matrix[arr[1]][arr[0]]=-1;
            }
        }
        matrix[1][1]=1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(matrix[i][j]==-1)matrix[i][j]=0;
                else{
                    if(i==1)matrix[i][j] += matrix[i][j-1];
                    else matrix[i][j] = (matrix[i-1][j]+matrix[i][j-1])%1000000007;
                }
            }
        }
        return matrix[n][m]% 1000000007;
    }
    public static void main(String[] args){
        System.out.println(new RoadToSchool().solution(4,4,new int[][]{{2,2},{3,3},{3,4}}));
    }
}
