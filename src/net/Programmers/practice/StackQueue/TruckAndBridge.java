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
        while (!truckList.isEmpty()) {
            Truck current = truckList.poll();
            if (current.weight + sum > weight||bridge.size()>=bridge_length) {
                while (current.weight + sum > weight||bridge.size()>bridge_length) {
                    Truck tmp = bridge.poll();
                    sum -= tmp.weight;
                    answer += tmp.distance;
                    answer--;
                }
            }
            answer++;
            for (Truck t : bridge) --t.distance;
            bridge.add(current);
            sum+=current.weight;
        }
        int max = 0;
        for(Truck t:bridge)max = Math.max(max,t.distance);
        answer+=max;
        return answer;
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
        System.out.println(new TruckAndBridge().solution(10, 10, new int[]{3,5,10,6,8,9,1,1,5,7}));
    }
}
