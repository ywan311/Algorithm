package com.kakao.test;

import java.util.Stack;

public class Test2 {
    public static String solution(String p) {
        if(p.length()==0)return "";
        String answer="";
        Stack<Character> stack = new Stack<>();
        char tmp =p.charAt(0);
        stack.push(tmp);
        int i=1;
        while(!stack.isEmpty()){
            if(stack.peek()==p.charAt(i)){
                stack.push(p.charAt(i++));
            }else{
                stack.pop();
                i++;
            }
        }
        String u = p.substring(0,i);
        String v = i==p.length()?"":p.substring(i);
        System.out.println(u+"    "+v);
        if(u.charAt(0)=='(')return answer=u+solution(v);
        else{
            StringBuilder builder = new StringBuilder();
            builder.append('(');
            String result = solution(v);
            builder.append(result);
            builder.append(')');
            for(int j=1;j<u.length()-1;j++){
                if(u.charAt(j)=='(')builder.append(')');
                else builder.append('(');
            }

            return answer = builder.toString();
        }
    }


    public static void main(String[] args) {
        Test2 test = new Test2();
        System.out.println("r"+test.solution(")))))((((("));
    }
}
