package net.Backjun.Heap;

import java.io.*;
import java.util.PriorityQueue;

public class P1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while(size-->0){
            int input = Integer.parseInt(br.readLine());
            if(input==0){
                bw.write(queue.isEmpty()?String.valueOf(0):String.valueOf(queue.poll()));
                bw.write("\n");
            }else queue.add(input);
        }
        bw.flush();
    }
}
