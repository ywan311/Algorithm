package net.Backjun;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] inputArr = br.readLine().split(" ");

        Stack<Building> stack = new Stack<>();
        for(int i =0;i<N;i++){
            Building current = new Building(i+1,Integer.parseInt(inputArr[i]));

            while(!stack.isEmpty()){
                if(stack.peek().height>= current.height){
                    bw.write(stack.peek().index+" ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()){
                bw.write("0 ");
            }
            stack.push(current);
        }

        bw.flush();
    }
    static class Building{
        int index;
        int height;

        public Building(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}
