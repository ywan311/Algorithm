package net.Backjun.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int a = 0;
        int b = 0;
        char[] arr1 = input[0].toCharArray();
        char[] arr2 = input[1].toCharArray();

        for(int i=0;i<3;i++){
            a = a*10+(arr1[2-i]-'0');
            b = b*10+(arr2[2-i]-'0');
        }
        System.out.println(Math.max(a,b));
    }
}
