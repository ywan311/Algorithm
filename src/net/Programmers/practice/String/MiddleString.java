package net.Programmers.practice;

public class MiddleString {
    public String solution(String s) {
        String answer = "";
        if(s.length()%2==0)answer = s.substring(s.length()/2-1,s.length()/2+1);
        else answer = Character.toString(s.charAt(s.length()/2));
        return answer;
        /*return s.substring((s.length()-1) / 2, s.length()/2 + 1); */
    }
    public static void main (String[] args){
        System.out.println(new MiddleString().solution("qwer"));
    }
}
