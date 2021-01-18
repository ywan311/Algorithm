package net.Programmers.practice.String;

import java.util.Arrays;

public class To2N {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while(s.length()>1){
            for (char c: s.toCharArray()) {
                if(c=='0')answer[1]++;
            }
            s = s.replaceAll("0","");
            s= to2(s.length());
            answer[0]++;
        }
        return answer;
    }
    String to2(int input){
        String result ="";
        while(input >1){
            result= (input%2) + result;
            input/=2;
        }
        result = input+result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new To2N().solution("110010101001")));
    }
}
