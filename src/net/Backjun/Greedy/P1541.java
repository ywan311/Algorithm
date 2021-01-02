package net.Backjun.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P1541 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] nums = input.split("[\\-+]");
        String[] notNums = input.split("[0-9]");
        List<Integer> queue = Arrays.stream(nums).map(Integer::parseInt).collect(Collectors.toList());
        List<String> notNumList = Arrays.stream(notNums).filter(a -> !a.equals("")).collect(Collectors.toList());

        int answer=queue.remove(0);

        boolean flag = false;

        for(String s: notNumList){
            if(s.equals("+")){
                if(flag){
                    answer-=queue.remove(0);
                }else answer+=queue.remove(0);
            }else{
                flag=true;
                answer-=queue.remove(0);
            }
        }
        System.out.println(answer);
    }
}
