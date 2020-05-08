package net.Backjun.String;

import java.util.Scanner;
import java.util.Stack;

public class ExploserString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String ex = input.nextLine();
        Stack<Character> stack = new Stack<>();
        for(int i=s.length()-1;i>=0;i--){
            boolean flag = false;
            char c = s.charAt(i);
            stack.push(c);
            if(c==ex.charAt(0)&&stack.size()>=ex.length()){
                flag = true;
                for(int j=0;j<ex.length();j++){
                    if(ex.charAt(j)!=stack.get(stack.size()-1-j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(int j=0;j<ex.length();j++)stack.pop();
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        if (stack.size()==0)System.out.println("FRULA");
        else {
            while(!stack.isEmpty())builder.append(stack.pop());
            System.out.println(builder);
        }
    }
}
