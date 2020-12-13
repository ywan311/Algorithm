package net.Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxExpression {
    public long solution(String expression) {
        long answer = 0;
        List<Long> numberList = new ArrayList<>();
        String[] numberArr = expression.split("[^0-9]");
        String[] operArr = expression.split("[0-9]");
        for (String s: numberArr)numberList.add(Long.parseLong(s));
        List<String> opertators = new ArrayList<>(Arrays.asList(operArr));
        opertators = opertators.stream().filter(a -> !a.equals("")).collect(Collectors.toList());
        System.out.println(numberList);
        System.out.println(opertators);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new MaxExpression().solution("100-200*300-500+20"));
    }
}
