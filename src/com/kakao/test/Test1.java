package com.kakao.test;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    static Map<String,Integer> map = new HashMap<>();
    static String str;
    static int answer;
    public int solution(String s) {
        answer = s.length();
        str=s;
        return answer;
    }
    public static void Compression(String s, int length, int startIdx){
        String tmp=str.substring(startIdx,length);

    }

    public static void main(String args[]) {
        Test1 test1 = new Test1();
        System.out.println(test1.solution("abcabcabcabcdededededede"));
    }
}