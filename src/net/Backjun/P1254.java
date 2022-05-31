package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        if(checkValid(input)){
            System.out.println(input.length());
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(input);
        char[] arr = input.toCharArray();
        for(int i =0;i<arr.length;i++){
            builder.insert(builder.length()-i,arr[i]);
            if(checkValid(builder.toString()))break;
        }
        System.out.println(builder.length());

    }
    static boolean checkValid(String s){
        char[] arr = s.toCharArray();
        for(int i =0;i<s.length()/2;i++){
            if(arr[i]!=arr[s.length()-1-i])return false;
        }
        return true;
    }
}
