package net.Backjun.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IOIOI {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int answer = 0;
        int p =0;
        for (int i = 1; i < input.length()-1; i++) {
            if((input.charAt(i-1)=='I')&&(input.charAt(i)=='O')&&(input.charAt(i+1)=='I')){
                p++;
                if(p==n){
                    answer++;
                    p--;
                }
                i++;
            }else p=0;
        }
        System.out.println(answer);
    }
}
