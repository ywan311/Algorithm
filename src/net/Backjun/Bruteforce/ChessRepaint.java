package net.Backjun.Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChessRepaint {
    static char[][] arr;
    static int width;
    static int height;
    static char[] check = new char[]{'B','W'};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String size[] = br.readLine().split(" ");
        width = Integer.parseInt(size[0]);
        height = Integer.parseInt(size[1]);
        for(int i=0;i<height;i++){
            arr[i] = br.readLine().toCharArray();
        }
        char[][] copy = new char[8][8];
        for(int i=0;i+8<height;i++){
            for(int j=0;j+8<width;j++){
                copy[i] = Arrays.copyOfRange(arr[i],j,j+7);
            }
        }
    }
}
