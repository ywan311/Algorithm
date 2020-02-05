package net.Programmers.practice.StackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//미완성
public class Truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum=0;
        Queue<Integer> truckList = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        for(int i : truck_weights){
            truckList.add(i);
        }
        while(!truckList.isEmpty()){
            int current = truckList.poll();

            if(sum+current>weight){
                answer+=bridge_length;
                answer--;
                sum=0;
                bridge.clear();
            }
            answer++;
            sum+=current;
            bridge.add(current);

        }
        if(!bridge.isEmpty())answer+=bridge_length;
        return answer;
    }
    public static void main(String[] args){
        System.out.println(new Truck().solution(100,100,new int[]{10,10,10,10,10,10,10,10,10,10,10}));
    }
}
