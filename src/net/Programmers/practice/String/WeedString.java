package net.Programmers.practice.String;

public class WeedString {
    public String solution(String s) {
        char[] answer = new char[s.length()];
        int cnt =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                answer[i]=' ';
                cnt=0;
                continue;
            }
            else if(cnt%2==0)answer[i] = Character.toUpperCase(s.charAt(i));
            else answer[i] = Character.toLowerCase(s.charAt(i));
            cnt++;
        }
        return new String(answer);
    }
    public static void main(String[] args){
        System.out.println(new WeedString().solution("try hello world"));
    }
}
