package net.Programmers.practice;

import java.util.Arrays;
import java.util.HashSet;

public class ConnectWord {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};
        char end=' ';
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<words.length;i++){
            if(set.contains(words[i])||words[i].charAt(0)!=end&&i!=0)return new int[]{i/n+1,i%n+1};
            else{
                end = words[i].charAt(words[i].length()-1);
                set.add(words[i]);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(new ConnectWord().solution(3,new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
    }
}
