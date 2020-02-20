package net.Programmers.practice.String;

public class PandY {
    boolean solution(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='p'||s.charAt(i)=='P')sum++;
            else if(s.charAt(i)=='y'||s.charAt(i)=='Y')sum--;
        }
        return sum==0?true:false;
    }
    public static void main(String[] args){
        System.out.println(new PandY().solution("ppyy"));
    }
}
