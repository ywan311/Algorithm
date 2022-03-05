package net.Backjun.Bruteforce;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindMin {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int i : A){
            queue.offer(i);
        }
        PriorityQueue<Integer> queue2 = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int i : B){
            queue2.offer(i);
        }

        while(!queue.isEmpty()){
            int a = queue.poll();
            int b = queue2.peek();

            if(b>a){
                answer++;
                queue2.poll();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new FindMin().solution(new int[]{5,1,3,7},new int[]{2,2,6,8}));
    }
}
