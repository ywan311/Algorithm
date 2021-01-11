package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);
        char[][] arr = new char[N][M];

        for(int i=0;i<N;i++){
            arr[i] = br.readLine().toCharArray();
        }

        int cnt1=Integer.MAX_VALUE;
        int cnt2=Integer.MAX_VALUE;
        char[] arr1 = new char[]{'B','W'};
        char[] arr2 = new char[]{'W','B'};
        for(int i=0;i<N-7;i++){
            for(int j=0;j<M-7;j++){
                int tmp1=0;
                int tmp2=0;
                for (int k = i;k<i+8;k++){
                    for(int l = j ;l<j+8;l++){
                        tmp1 += arr[k][l]==arr1[(k+l)%2]?1:0;
                        tmp2 += arr[k][l]==arr2[(k+l)%2]?1:0;
                    }
                }
                cnt1 = Math.min(cnt1,tmp1);
                cnt2 = Math.min(cnt2,tmp2);
            }
        }
        System.out.println(Math.min(cnt1,cnt2));
    }
}
