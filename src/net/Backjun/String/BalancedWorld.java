package net.Backjun.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BalancedWorld {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();
        while (true) {
            String s = br.readLine();
            if (s.length() == 1 && s.charAt(0) == '.') break;
            stack.clear();
            boolean flag = false;
            for (char c : s.toCharArray()) {
                if(c!='('&&c!=')'&&c!='['&&c!=']')continue;
                if (c == '(' || c == '[') stack.push(c);
                else {
                    try {
                        if (c == ')' && stack.peek() == '(') stack.pop();
                        else if (c == ']' && stack.peek() == '[') stack.pop();
                        else {
                            flag = true;
                            break;
                        }
                    } catch (Exception e) {
                        flag = true;
                        break;
                    }
                }
            }
            bw.write(!flag && stack.isEmpty() ? "yes\n" : "no\n");
        }


        bw.flush();
    }
}
