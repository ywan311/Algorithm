package net.Backjun.String;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    static int answer = 1;

    public int solution(String s) {
        //홀수일경우
        int tmp_length=1;
        for(int i=0;i<s.length()-1;i++){
            tmp_length=1;
            for(int j=i-1;j>=0;j--){
                try{
                    if(s.charAt(j)==s.charAt(i+i-j))tmp_length+=2;
                    else break;
                }catch (Exception err){
                    break;
                }
            }
            answer = Math.max(tmp_length,answer);
        }
        for (int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                tmp_length=0;
                for(int j=i+1;j<s.length();j++){
                    try {
                        if(s.charAt(j)==s.charAt(i+1-j+i))tmp_length+=2;
                        else break;
                    }catch (Exception err){
                        break;
                    }
                }
                answer = Math.max(tmp_length,answer);
            }
        }
        return answer;
    }



    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().solution("aaaabbbbbccccccc"));
    }
}
