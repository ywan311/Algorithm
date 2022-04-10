package net.Programmers;

import java.util.*;

public class SortLong {
    public long solution(long n) {
        List<Character> s = new ArrayList<>();
        for (char c : String.valueOf(n).toCharArray()){
            s.add(c);
        }

        s.sort(Collections.reverseOrder());

        System.out.println(s);
        StringBuilder answer = new StringBuilder();

        for(Character c: s){
            answer.append(c);
        }


        return Long.parseLong(answer.toString());
    }

    public static void main(String[] args) {
        System.out.println(new SortLong().solution(118372));
    }
}

