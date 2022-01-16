package net.Programmers;

import java.util.*;

public class ResultOfDeclaration {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Set<String> set = new HashSet<>();
        Map<String,Set<String>> map = new HashMap<>();
        Map<String,Integer> indexMap = new HashMap<>();
        for (int i =0;i< id_list.length;i++) {
            map.put(id_list[i], new HashSet<>());
            indexMap.put(id_list[i],i);
        }

        for(String s : report){
            if(set.contains(s))continue;
            set.add(s);

            String[] input = s.split(" ");
            map.get(input[1]).add(input[0]);

        }
        for(String s : map.keySet()){
            if(map.get(s).size()>=k){
                for(String s2 : map.get(s)){
                    answer[indexMap.get(s2)]++;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        String [] p1 = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] p2 = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        System.out.println(Arrays.toString(new ResultOfDeclaration().solution(p1,p2,2)));
    }
}
