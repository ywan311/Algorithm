package net.Programmers.practice;

import java.util.ArrayList;

public class Truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum=0;
        ArrayList<Integer> truckList = new ArrayList<>();
        ArrayList<Integer> bridge = new ArrayList<>();
        for(int i : truck_weights){
            truckList.add(i);
        }
        while(!truckList.isEmpty()){
            if(sum+truckList.get(0)<=weight&&bridge.size()<=bridge_length){
                sum+=truckList.get(0);
                bridge.add(truckList.remove(0));
                answer++;
            }else{
                if(bridge.size()>1){
                    for(int i=0;i<bridge.size();i++){
                        sum-=bridge.remove(0);
                        if(sum+truckList.get(i)<=weight)answer--;
                    }
                }
                else{
                    sum-=bridge.remove(0);
                }
                answer+=bridge_length;
                if(bridge.isEmpty()){
                    sum+=truckList.get(0);
                    bridge.add(truckList.remove(0));
                }
            }
            System.out.println(bridge);
            System.out.println(answer);
        }
        if(!bridge.isEmpty())answer+=bridge_length;
        return answer;
    }
    public static void main(String[] args){
        System.out.println(new Truck().solution(2,10,new int[]{7,4,5,6}));
    }
}
