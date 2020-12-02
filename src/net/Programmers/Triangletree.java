package net.Programmers;

import java.util.Arrays;

public class Triangletree {
    public int[] solution(int n) {
        int max =0;
        for(int i=n;i>0;i--)max+=i;

        int[][] arr = new int[n][n];
        for(int[] i :arr) Arrays.fill(i,-1);

        int value=1;
        int i = 0,j =0;
        arr[i][j]=1;
        while(value<max){
            while(i+1<n && value<max && arr[i+1][j]<0){
                arr[++i][j]=++value;
            }
            while (j+1<n && value< max && arr[i][j+1]<0){
                arr[i][++j]= ++value;
            }
            while(i-1>0 && j-1> 0 && value < max&& arr[i-1][j-1]<0){
                arr[--i][--j] = ++value;
            }
        }
        int[] answer = new int[max];

        int cnt=0;
        for( int a =0;a<n;a++){
            for( int b=0;b<=a;b++){
                System.out.println(cnt);
                answer[cnt++] =arr[a][b];
            }
        }

       return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Triangletree().solution(1000)));
    }
}
