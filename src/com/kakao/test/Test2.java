package com.kakao.test;

import java.util.Stack;

public class Test2 {
    static String answer = "";

    public String solution(String p) {
            splitString(p);
        return answer;
    }

    public String splitString(String s) {
        if (s.length() == 0) return "";
        else {
            int cntFirst = 1;
            char tmp = s.charAt(0);
            String u = "";
            String v = "";
            for (int i = 1; i < s.length(); i++) {
                if (tmp != s.charAt(i)) cntFirst -= 1;
                else cntFirst += 1;
                if (cntFirst == 0) {
                    u = s.substring(0, i + 1);
                    if (i + 1 < s.length())
                        v = s.substring(i + 1);
                    break;
                }
            }
            System.out.println("U=" + u + "V=" + v);
            answer += splitString(v);
            answer = confirmU(u) + answer;
            return answer;

        }
    }

    public String confirmU(String s) {
        try {
            if (s.charAt(0) == '(') return s;
            else {
                Stack<Character> tmp = new Stack<>();
                System.out.println(s);
                String middle = s.substring(1, s.length() - 1);
                String value = "(";
                for (Character c : middle.toCharArray()) {
                    if (c == '(') value += ')';
                    else value += '(';
                }

                return value + ')';
            }
        } catch (Exception err) {
            return err.toString();
        }

    }

    public static void main(String[] args) {
        Test2 test = new Test2();
        System.out.println(test.splitString("()))((()"));
    }
}
