package net.Backjun.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P1316 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<Character> set = new HashSet<>();
        int answer = 0;
        while(n-->0){
            char[] input = br.readLine().toCharArray();
            if(input.length<=1){
                answer++;
                continue;
            }
            set.clear();
            set.add(input[0]);
            for(int i=1;i< input.length;i++){
                if(input[i] != input[i-1])
                    if(set.contains(input[i]))break;
                    else set.add(input[i]);

                if(i==input.length-1)answer++;
            }
        }
        System.out.println(answer);
    }
}
