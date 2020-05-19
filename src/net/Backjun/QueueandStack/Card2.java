package net.Backjun.QueueandStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Card2 {
    static int N;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        for(int i=1;i<=N;i++){
            queue.offer(i);
        }
        while(queue.size()>1){
            queue.poll();
            queue.offer(queue.poll());
        }
        System.out.println(queue.poll());
    }

}
