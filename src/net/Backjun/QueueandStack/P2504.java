package net.Backjun.QueueandStack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P2504 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        int answer=0;
        int tmp=0;

        try {
            for(char c: input.toCharArray()){
                if(c=='['||c=='(')stack.push(c);
                else{
                    char d = stack.pop();
                    if(c==')'&&d=='('){
                        if(tmp==0)tmp=2;
                        else tmp*=2;
                    }
                    else if(c==']'&&d=='['){
                        if(tmp==0)tmp=3;
                        else tmp*=3;
                    }
                    else throw new Exception();
                    if(stack.isEmpty()){
                        answer+=tmp;
                        tmp=0;
                    }
                    System.out.println(answer+"/"+tmp);
                }
            }
            if(stack.isEmpty()&& tmp==0) System.out.println(answer);
            else System.out.println(0);
        } catch (Exception e) {
            System.out.println(0);
        }
    }
}
