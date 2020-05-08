package net.Programmers.practice;

import java.util.*;

public class Tuples {
    public int[] solution(String s) {
        List<Integer> list = new ArrayList<>();
        String[] arr = s.replaceAll("\\{","").split("},");
        arr[arr.length-1] = arr[arr.length-1].replaceAll("\\}","");
        Arrays.sort(arr,(o1, o2) -> o1.length()-o2.length());
        for(String str:arr){
            String strArr[] = str.split(",");
            for(String elements: strArr){
                if(!list.contains(Integer.parseInt(elements)))list.add(Integer.parseInt(elements));
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Tuples().solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
    }
}
