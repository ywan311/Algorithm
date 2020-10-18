package test;

import java.util.Arrays;

public class test2 {
    private String solution(String input){
        String[] s = input.split("[^0-9]");
        return (input.toCharArray()[5]=='P'?String.valueOf(Integer.parseInt(s[0])+12):s[0])+":"+s[1];
    }
    public static void main(String[] args) {
        System.out.println(new test2().solution("07:20AM"));
    }
}
