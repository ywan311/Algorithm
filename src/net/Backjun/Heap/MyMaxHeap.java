package net.Backjun.Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MyMaxHeap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int loop;
        loop = input.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) ->o2 - o1 );
        while(loop-->0){
            int value = input.nextInt();

            if( value==0){
                if(queue.isEmpty())System.out.println(0);
                else System.out.println(queue.poll());
            }else{
                queue.offer(value);
            }
        }
    }
}
