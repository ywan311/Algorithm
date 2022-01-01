package net.Programmers;

import java.util.*;
import java.util.stream.Collectors;

public class MaxExpression {
    static List<Long> staticNumberList = new ArrayList<>();
    static List<String> opertators;
    static long answer = 0L;

    public long solution(String expression) {

        String[] numberArr = expression.split("[^0-9]");
        String[] operArr = expression.split("[0-9]");
        for (String s : numberArr) staticNumberList.add(Long.parseLong(s));

        opertators = new ArrayList<>(Arrays.asList(operArr));
        opertators = opertators.stream().filter(a -> !a.equals("")).collect(Collectors.toList());

        Set<String> set = new HashSet<>(opertators);

        System.out.println(staticNumberList);
        System.out.println(opertators);


        return answer;
    }


    public static void main(String[] args) {
        System.out.println(new MaxExpression().solution("50*6-3*2"));
    }
}
