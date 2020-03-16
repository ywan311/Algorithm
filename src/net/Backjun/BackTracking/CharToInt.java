package net.Backjun.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CharToInt {
    static int N;
    static List<String> list = new LinkedList<>();
    static Map<Character,Integer> map = new HashMap<>();
    static int value =9;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            list.add(br.readLine());
        }
        System.out.println(list);
        for(String s:list){
            int n=s.length()-1;
            int index=0;
            while(n>=0){
                char c = s.charAt(index++);
                if(!map.isEmpty()&&map.containsKey(c))map.put(c,map.get(c)+(int)Math.pow(10,n));
                else map.put(c,(int) Math.pow(10,n));
                n--;
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for(char c:map.keySet()){
            answer.add(map.get(c));
        }
        Collections.sort(answer, Collections.reverseOrder());
        int sum=0;
        for(int i:answer){
            sum+=i*value--;
        }
        System.out.println(sum);
    }
}
