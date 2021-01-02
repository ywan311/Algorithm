package net.Programmers.practice.String;

import java.util.Arrays;

public class JadenCase {
    public String solution(String s) {
        boolean flag = true;
        StringBuilder builder = new StringBuilder();

        for(char c: s.toCharArray()){
            if(flag){
                builder.append(Character.toUpperCase(c));
                if(c!=' ')flag=false;
            }else {
                builder.append(Character.toLowerCase(c));
                if(c==' ')flag=true;
            }

        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new JadenCase().solution(" hEllo    1woRld"));
    }
}
