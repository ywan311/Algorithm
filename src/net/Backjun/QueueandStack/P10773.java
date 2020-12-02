package net.Backjun.QueueandStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int n =Integer.parseInt(br.readLine());

        while(n-->0){
            int input =Integer.parseInt(br.readLine());
            if(input==0)stack.pop();
            else stack.push(input);
        }
        int sum =0;
        for(int i:stack)sum+=i;
        System.out.println(sum);
    }
}
