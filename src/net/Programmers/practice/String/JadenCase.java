package net.Programmers.practice.String;

import java.util.Arrays;

public class JadenCase {
    public String solution(String s) {
        String answer = "";
        String str[] = s.split(" ");
        System.out.println(Arrays.toString(str));
        for(int j=0;j<str.length;j++){
            char[] arr =  str[j].toCharArray();
            StringBuilder builder = new StringBuilder();
            for(int i=0;i<arr.length;i++){
                if(i==0)builder.append(Character.toUpperCase(arr[i]));
                else builder.append(Character.toLowerCase(arr[i]));
            }
            str[j] = builder.toString();
        }
        StringBuilder builder = new StringBuilder();
        for(String tmp:str)builder.append(tmp+" ");
        String blank = "";
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' ')blank+=" ";
            else break;
        }

        return builder.toString().substring(0, builder.length()-1)+blank;
    }

    public static void main(String[] args) {
        System.out.println(new JadenCase().solution("3people unFollowed me  "));
    }
}
