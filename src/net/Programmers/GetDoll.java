package net.Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GetDoll {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Queue<Integer>[] queues = (Queue<Integer>[]) new Queue[board[0].length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<queues.length;i++)queues[i] = new LinkedList<>();
        for(int tmp[]: board){
            for(int i=0;i<tmp.length;i++){
                if(tmp[i]>0)queues[i].add(tmp[i]);
            }
        }
        for(int i: moves){
            if(queues[i-1].size()==0)continue;
            int value = queues[i-1].poll();
            if(!stack.isEmpty()&&stack.peek()==value){
                stack.pop();
                answer+=2;
            }else stack.push(value);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new GetDoll().solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}},new int[]{1,5,3,5,1,2,1,4}));
    }
}
