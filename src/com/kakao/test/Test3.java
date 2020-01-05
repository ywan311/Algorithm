package com.kakao.test;

import java.util.Arrays;
import java.util.TreeMap;

public class Test3 {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        int i=0;
        for (String s:queries) {
            answer[i]=confirm(words,toMap(s),s.length());
            i++;
        }
        return answer;
    }
    public TreeMap toMap(String query){
        TreeMap<Integer,Character> map = new TreeMap<>();
        for(int i =0; i<query.length();i++){
            if(query.charAt(i)!='?')map.put(i,query.charAt(i));
        }
        return map;
    }
    public int confirm(String[] words, TreeMap<Integer,Character> map,int length){
        boolean flag;
        int value=0;
        for(String s : words){
            if(s.length()==length) {
                flag = true;
                for (Integer key : map.keySet()) {
                    if (s.charAt(key) != map.get(key)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) value++;
            }
        }
        return value;
    }
    public static void main(String[] args){
        Test3 test3 = new Test3();
        String[] input1 = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] input2 = {"fro??", "????o", "fr???", "fro???", "pro?"};

        System.out.println(Arrays.toString(test3.solution(input1,input2)));
    }
}
