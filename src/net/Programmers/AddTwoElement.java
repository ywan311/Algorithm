package net.Programmers;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class AddTwoElement {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();

        for(int i=0;i<numbers.length-1;i++){
            for(int j = i+1;j<numbers.length;j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        int[] answer = new int[set.size()];
        int i =0;
        for(Integer a: set)answer[i++] = a;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AddTwoElement().solution(new int[]{2,1,3,4,1})));
    }
}
