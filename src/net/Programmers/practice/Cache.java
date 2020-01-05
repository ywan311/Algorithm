package net.Programmers.practice;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        if(cacheSize==0)return cities.length*5;
        for(String city : cities){
            StringBuffer buffer = new StringBuffer();
            for(char c:city.toCharArray()){
                buffer.append(Character.toLowerCase(c));
            }
            String s = buffer.toString();
            if(queue.contains(s)){
                answer++;
                queue.remove(s);
                queue.add(s);
            }else{
                answer+=5;
                if(queue.size()>=cacheSize)queue.poll();
                queue.add(s);

            }
            System.out.println(queue);
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(new Cache().solution(0,new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
    }
}
