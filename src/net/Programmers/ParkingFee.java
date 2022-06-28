package net.Programmers;

import java.util.*;
/**
 * 미완성
 * 프로그래머스 주차요금계산
 * https://programmers.co.kr/learn/courses/30/lessons/92341
 * */
public class ParkingFee {
    public int[] solution(int[] fees, String[] records) {
        Map<String,Integer> in = new HashMap<>();
        Map<String,Integer> out = new TreeMap<>();
        Set<String> set = new HashSet<>();
        for(String s : records){
            String[] input = s.split(" ");
            String[] timeStr = input[0].split(":");
            int time = Integer.parseInt(timeStr[0])*60+Integer.parseInt(timeStr[1]);
            set.add(input[1]);
            if(input[2].equals("IN")){
                in.put(input[1],time);
            }else{
                out.put(input[1],out.getOrDefault(input[1],0)+time-in.get(input[1]));
                in.remove(input[1]);
            }
        }
        int[] answer = new int[set.size()];
        int i =0;
        for(String s:out.keySet()){
            int duration = out.getOrDefault(s,23*60+59-in.getOrDefault(s,23*60+59));
            if(in.containsKey(s))duration+=23*60+59-in.getOrDefault(s,23*60+59);
            in.remove(s);
            int fee = fees[1];
            int pivot = duration-fees[0];
            fee += pivot<=0?0:(pivot/fees[2]+(pivot%fees[2]==0?0:1))*fees[3];
            answer[i++] = fee;
        }
        for(String s : in.keySet()){
            int duration =23*60+59-in.getOrDefault(s,23*60+59);
            int fee = fees[1];
            int pivot = duration-fees[0];
            fee += pivot<=0?0:(pivot/fees[2]+(pivot%fees[2]==0?0:1))*fees[3];
            answer[i++] = fee;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] fees = new int[]{1, 461, 1, 10};
        String[] records = new String[]{"00:00 1234 IN"};
        System.out.println(Arrays.toString(new ParkingFee().solution(fees,records)));
    }
}
