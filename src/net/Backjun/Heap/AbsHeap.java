package net.Backjun.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AbsHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)==Math.abs(o2))return o1-o2;
                else return Math.abs(o1)-Math.abs(o2);
            }
        });
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        while(n>0){
            int num = input.nextInt();
            if(num==0){
                if(queue.isEmpty())System.out.println(0);
                else System.out.println(queue.poll());
            }else{
                queue.offer(num);
            }
            n--;
        }
    }
}
