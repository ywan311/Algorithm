package net.Programmers;

import java.util.*;
import java.util.stream.Collectors;

public class MaxExpression {
    static List<Long> staticNumberList = new ArrayList<>();
    static List<String> opertators;
    static char[][] combArr= new char[][]{{'+','-','*'},{'+','*','-'},{'*','-','+'},{'*','+','-'},{'-','+','*'},{'-','*','+'}};
    static long answer = 0L;

    public long solution(String expression) {

        String[] numberArr = expression.split("[^0-9]");
        String[] operArr = expression.split("[0-9]");
        for (String s : numberArr) staticNumberList.add(Long.parseLong(s));

        opertators = new ArrayList<>(Arrays.asList(operArr));
        opertators = opertators.stream().filter(a -> !a.equals("")).collect(Collectors.toList());


        for (char[] chars : combArr) {
            getMax(chars);
        }

        return answer;
    }

    void getMax(char[] arr){
        List<Long> numberCal = new ArrayList<>(staticNumberList);

        List<String> operatorCal = new ArrayList<>(opertators);
        for(char c : arr){
            for(int i =0;i<operatorCal.size();i++){
                long tmp = 0L;
                if(operatorCal.get(i).charAt(0)==c){
                    switch (c){
                        case '+':
                            tmp = numberCal.get(i)+numberCal.get(i+1);
                            break;
                        case '-':
                            tmp = numberCal.get(i)-numberCal.get(i+1);
                            break;
                        case '*':
                            tmp = numberCal.get(i)*numberCal.get(i+1);
                            break;
                    }
                    numberCal.remove(i);
                    numberCal.remove(i);
                    numberCal.add(i,tmp);
                    operatorCal.remove(i);
                    i--;
                }
            }
        }
        answer = Math.max(answer,Math.abs(numberCal.get(0)));
    }


    public static void main(String[] args) {
        System.out.println(new MaxExpression().solution("100-200*300-500+20"));
    }
}
