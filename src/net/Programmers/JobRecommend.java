package net.Programmers;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class JobRecommend {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        TreeMap<String,Integer> score = new TreeMap<>();

        Map<String, ArrayList<String>> tableMap = new HashMap<>();

        for(String s : table){
            String[] arr = s.split(" ");
            tableMap.put(arr[0],new ArrayList<>());
            tableMap.get(arr[0]).addAll(Arrays.asList(Arrays.copyOfRange(arr,1,arr.length)));
        }

        System.out.println(tableMap);
        for(int i=0;i<languages.length;i++){
            String language = languages[i];
            int value = preference[i];

            for(String key: tableMap.keySet()){

                AtomicInteger scoreValue = new AtomicInteger(5);
                tableMap.get(key).forEach( o -> {
                    if(o.equals(language)){
                        if(score.containsKey(key))score.put(key,score.get(key)+scoreValue.get()*value);
                        else score.put(key,scoreValue.get()*value);
                    }
                    scoreValue.getAndDecrement();
                });
            }

        }
        int max =0;

        for (String key : score.keySet()) {
            if (max < score.get(key)) {
                max = score.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] table = new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages = new String[]{"PYTHON", "C++", "SQL"};
        int[] preference = new int[]{ 7, 5, 5 };
        System.out.println(new JobRecommend().solution(table,languages,preference));
    }
}
