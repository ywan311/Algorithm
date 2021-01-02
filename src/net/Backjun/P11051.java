package net.Backjun;

import java.util.Arrays;
import java.util.Scanner;

public class P11051 {
    static int[][] arr= new int[30][30];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        for(int i=1;i<30;i++){
            for(int j=i;j<30;j++){
                if(i==j)arr[i][j]=1;
                else arr[i][j]=arr[i-1][i-1]+arr[i][j-1];
            }
        }
        for(int[] a:arr) System.out.println(Arrays.toString(a));
    }
}
