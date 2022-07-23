package net.Programmers;

import java.util.ArrayList;
import java.util.List;

public class SplitArrary {
    public int[] solution(int n, long left, long right) {
        List<Integer> list = new ArrayList<>();
        for(;left<=right;left++){
            long row = (left/n)+1;
            long col = (left%n)+1;
            list.add(row>=col?(int)row:(int)col);
        }
        int[] answer = new int[list.size()];
        for(int i =0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        new SplitArrary().solution(4,7,14);
    }
}
