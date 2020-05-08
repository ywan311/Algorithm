package net.Backjun.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class GoodWord {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(input.readLine());
        Stack<Character> stack = new Stack();
        int answer =0;
        while(loop-->0){
            String value = input.readLine();
            for(char c: value.toCharArray()){
                if(stack.isEmpty()||stack.peek()!=c)stack.push(c);
                else stack.pop();
            }
            if(stack.size()==0)answer++;
            stack.clear();
        }
        System.out.println(answer);
    }
}
