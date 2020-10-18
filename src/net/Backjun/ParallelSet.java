package net.Backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ParallelSet {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size[] = new int[2];
        String[] stringSize = br.readLine().split(" ");
        size[0] = Integer.parseInt(stringSize[0]);
        size[1] = Integer.parseInt(stringSize[1]);

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        String[] input1 = br.readLine().split(" ");
        for(String s : input1)set1.add(Integer.parseInt(s));

        String[] input2 = br.readLine().split(" ");
        for(String s : input2)set2.add(Integer.parseInt(s));

        HashSet<Integer> set3 = new HashSet<>();

        set3.addAll(set1);
        set3.addAll(set2);

        int answer = (set3.size()-set1.size())+ (set3.size()-set2.size());
        System.out.println(answer);
    }

}
