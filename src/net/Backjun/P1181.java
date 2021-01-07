package net.Backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class P1181 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length())return o1.compareToIgnoreCase(o2);
                else return o1.length()-o2.length();
            }
        });
        HashSet<String> set = new HashSet<>();
        while(size-->0){
            set.add(br.readLine());
        }
        for(String s: set)queue.offer(s);
        while(!queue.isEmpty()) System.out.println(queue.poll());

    }
}
