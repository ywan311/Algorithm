package net.Backjun.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gap {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String a = input[0];
        String b = input[1];
        int min = a.length();
        for(int i=0;i+a.length()<=b.length();i++){
            int tmp=0;
            for(int j=0;j<a.length();j++){
                if(a.charAt(j)!=b.charAt(i+j)){
                    tmp++;
                }
            }
            if(min>tmp){
                min = tmp;
            }
        }
        System.out.println(min);
    }
}
