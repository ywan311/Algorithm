package net.Programmers.practice.String;

import java.util.Stack;

public class PairRemove {
    public int solution(String s){

        Stack<Character> stack = new Stack<>();

        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(!stack.isEmpty()&&stack.peek()==arr[i]&&arr[i]!=' '){
                stack.pop();
                continue;
            }else stack.push(arr[i]);
        }

        return stack.isEmpty()?1:0;
    }

    public static void main (String[] args){
        System.out.println(new PairRemove().solution("abba"));
    }
}
