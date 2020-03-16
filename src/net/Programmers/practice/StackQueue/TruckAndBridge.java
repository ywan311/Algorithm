package net.Programmers.practice.StackQueue;

import java.util.LinkedList;
import java.util.Queue;

//미완성
public class TruckAndBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Truck> truckList = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();
        for (int i : truck_weights) {
            truckList.add(new Truck(i, bridge_length));
        }
        int time=0;
        while (!(truckList.isEmpty()&&bridge.isEmpty())) {
            time++;

            if(!bridge.isEmpty()&&bridge.peek().distance<=0){
                sum-=bridge.poll().weight;
            }
            if(!truckList.isEmpty()&& weight - sum - truckList.peek().weight >=0 ){
                sum+=truckList.peek().weight;
                bridge.offer(truckList.poll());
            }
            for(Truck t: bridge)t.distance--;

        }
        return time;
    }

    private class Truck {
        int weight;
        int distance;

        public Truck(int weight, int distance) {
            this.weight = weight;
            this.distance = distance;
        }

    }

    public static void main(String[] args) {
        System.out.println(new TruckAndBridge().solution(100, 10, new int[]{3,5,10,6,8,9,1,1,5,7}));
    }
}
