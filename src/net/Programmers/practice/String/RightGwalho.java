package net.Programmers.practice.String;

import java.util.Stack;

public class RightGwalho {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(')stack.push('(');
            else{
                if(stack.isEmpty())return false;
                else stack.pop();
            }
        }

        return stack.isEmpty()?true:false;
    }
}
