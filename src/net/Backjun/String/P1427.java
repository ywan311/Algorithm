package net.Backjun.String;

import java.io.*;
import java.util.PriorityQueue;

public class P1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        PriorityQueue<Character> queue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));

        for(char c : input.toCharArray()){
            queue.offer(c);
        }
        while(!queue.isEmpty())bw.write(queue.poll());

        bw.flush();
    }
}


