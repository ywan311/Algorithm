package net.Programmers.practice.Heap;


import java.util.PriorityQueue;

public class Scoville {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i:scoville){
            heap.add(i);
        }
        do{
            int first = heap.isEmpty()?0:heap.poll();
            int second = heap.isEmpty()?0:heap.poll();
            heap.add(first+second*2);
            answer++;
            if(heap.size()<=1)break;
        }while(heap.peek()<=K);
        if(heap.peek()>=K)return answer;
        else return -1;
    }
    public static void main(String[] args){
        System.out.println(new Scoville().solution(new int[] {1,2,3},11));
    }
}
