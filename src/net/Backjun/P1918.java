package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();

        for(int i =0;i<input.length;i++){
            char c = input[i];
            System.out.println(c);
            if(c>='A' && c<='Z'){
                builder.append(c);
            }else{
                if (c == '(') {
                    stack.add(c);
                }else if(c==')'){
                    while(stack.peek()!='('){
                        char c2 = stack.pop();
                        builder.append(c2);
                    }
                    stack.pop();
                }else if(c=='*'||c=='/'){
                    while(!stack.isEmpty() && (stack.peek()=='*'||stack.peek()=='/')){
                        builder.append(stack.pop());
                    }
                    stack.add(c);
                }else{
                    while(!stack.isEmpty() && (stack.peek()!='(')){
                        builder.append(stack.pop());
                    }
                    stack.add(c);
                }
            }
            System.out.println(builder);
            System.out.println(stack);
        }

        while(!stack.isEmpty()){
            char c = stack.pop();
            if(c!='('){
                builder.append(c);
            }
        }
        System.out.println(builder);
    }
}
