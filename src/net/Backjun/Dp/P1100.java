package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] arr = new boolean[8][8];

        for(int i=0;i<8;i++){
            String input = br.readLine();
            for(int j=0;j<8;j++){
                arr[i][j]=input.charAt(j)=='F';
            }
        }
        int answer=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if((i+j)%2==0&&arr[i][j])answer++;
            }
        }
        System.out.println(answer);
    }
}
