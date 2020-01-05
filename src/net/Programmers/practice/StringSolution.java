package net.Programmers.practice;


import java.util.Arrays;

public class StringSolution {
    public boolean solution(String s) {
        if(s.length()==4||s.length()==6){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            if(arr[arr.length-1]>'9')return false;
            else return true;
        }else return false;
    }
    public static void main(String[] args){
        System.out.println(new StringSolution().solution("a123"));
    }
}
