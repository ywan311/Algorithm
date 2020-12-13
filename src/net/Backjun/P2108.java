package net.Backjun;

import java.io.*;
import java.util.*;

public class P2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        List<Integer> input = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int sum=0;
        for (int i = 0; i < size; i++) {
            int value = Integer.parseInt(br.readLine());
            sum+=value;
            if(map.containsKey(value)){
                map.put(value,map.get(value)+1);
            }else map.put(value,1);
            input.add(value);
        }
        List<Integer> index=new ArrayList<>();
        int max= 0;
        for(int i: map.keySet()){
                if(max<map.get(i)){
                    max = map.get(i);
                    index.clear();
                    index.add(i) ;
                }else if(max==map.get(i))index.add(i);
        }
        input.sort((o1, o2) -> o2-o1);
        index.sort((o1, o2) -> o1-o2);

        System.out.println((int)Math.round(((double)sum)/(double)(input.size())));
        System.out.println(input.get(input.size()/2));
        System.out.println(index.size()>1?index.get(1):index.get(0));
        System.out.println(Math.abs(input.get(input.size()-1)-input.get(0)));

    }

    public static int average(List<Integer> input) {
        int amount = 0;

        for (int i = 0; i < input.size(); i++) {
            amount = amount + input.get(i);
        }
        return Math.round(amount/input.size());
    }
    public static int central(List<Integer> input) {
        input.sort((o1, o2) -> o1 > o2 ? 1 : o1 < o2 ? -1 : o1 == o2 ? 0 : -99);

        int center = input.size()/2;
        System.out.println("input => "+ input.toString());
        return input.get(center);
    }
    public static int min(List<Integer> input) {
        int result = 0;
        int temp = 0;
        if (input.size() > 1) {
            input.sort((o1, o2) -> o1 > o2 ? 1 :o1 < o2 ? -1 : o1 == o2 ? 0 : -99);

            for (int i = 0; i < input.size(); i++) {
                if (input.get(0) < input.get(i)) {
                    temp = input.get(i);
                    result = temp;
                    break;
                }
            }

        } else {
            input.sort((o1, o2) -> o1 > 02 ? 1 :o1 < o2 ? -1 : o1 == o2 ? 0 : -99);
            result = input.get(0);
        }

        return result;
    }
    public static int range(List<Integer> input) {
        input.sort((o1, o2) -> o1 > 02 ? 1 :o1 < o2 ? -1 : o1 == o2 ? 0 : -99);
        if (input.size() > 1 ) {
            if (input.get(0) < 0 && input.get(input.size()-1) >= 0)
                return Math.abs(input.get(0))+Math.abs(input.get(input.size()-1));
            else if (input.get(0) < 0 && input.get(input.size()-1) < 0)
                return Math.abs(input.get(0)) - Math.abs(input.get(input.size() - 1));
            else
                return Math.abs(input.get(input.size()-1)) - Math.abs(input.get(0));
        }else {
            return input.size()-1;
        }


    }

}