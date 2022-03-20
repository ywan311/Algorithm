package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i =0;i<N;i++){
            queue.offer(Integer.parseInt(br.readLine()));
        }
        int sum =0;
        int a = queue.poll();
        while(!queue.isEmpty()){
            int b = queue.poll();
            a = a+b;
            sum+=a;
            if(!queue.isEmpty()&&a>queue.peek()){
                int tmp = queue.poll();
                queue.offer(a);
                a=tmp;
            }
        }
        System.out.println(sum);
    }
}
