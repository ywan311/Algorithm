package net.Programmers.practice;

import java.util.ArrayList;

public class Printer {
    public int solution(int[] priorities, int location) {
        //오름차순으로 정렬 후 queue에서 하나씩 dequeue하면서 location--, answer++
        //location==0일때 answer를 리턴
        int answer=0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i :priorities)list.add(i);

        while(!list.isEmpty()){
            int max = list.get(0);
            for(int i =1;i<list.size();i++){
                if(list.get(0)<list.get(i)){
                    location = location==0?list.size()-1:location-1;

                    list.add(list.remove(0));
                    max=0;
                    break;
                }
            }
            if(max!=0){
                list.remove(0);
                answer++;
                if(location==0)break;
                else location--;
            }
            System.out.println(list);
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(new Printer().solution(new int[] {1, 1, 9, 1, 1, 1},0));
    }
}
