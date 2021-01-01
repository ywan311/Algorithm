package net.Backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P1874 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int index = 1;
        for (int current : arr) {
            if (index <= current) {
                for (; index <= current; index++) {
                    stack.push(index);
                   builder.append("+\n");
                }
            }
            if (!stack.isEmpty() && current == stack.peek()) {
                builder.append("-\n");
                stack.pop();
            } else {
                System.out.println("NO");
                return;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("NO");
            return;
        }
        System.out.println(builder.toString());
    }
}
