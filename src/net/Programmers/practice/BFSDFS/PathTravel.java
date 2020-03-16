package net.Programmers.practice.BFSDFS;

import java.util.*;
import java.util.stream.Collectors;

public class PathTravel {
    static Map<String, List<String>> map = new HashMap<>();
    static String[] answer;
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length+1];
        for(String[] s: tickets){
           if(map.isEmpty()||!map.containsKey(s[0])){
               map.put(s[0],new LinkedList<>());
           }
           map.get(s[0]).add(s[1]);
        }
        for(String s:map.keySet()){
            Collections.sort(map.get(s),(String o1, String o2) -> o1.compareTo(o2));
        }
        System.out.println(map);
        DFS("ICN",0);
        return answer;
    }
    static void DFS(String key,int depth){
        answer[depth] = key;
        if(depth==answer.length-1)return;
        if(!map.containsKey(key))return;
        for(int i=0;i<map.get(key).size();i++){
            String next = map.get(key).remove(0);
            System.out.println(key+"  "+next);
            DFS(next,depth+1);
            if(answer[answer.length-1]!=null)return;
            map.get(key).add(next);
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PathTravel().solution(new String[][]	{{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}})));
    }
}
