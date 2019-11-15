package net.Programmers.practice;

public class Jjak {
    public static int solution(String s) {
        if(s.length()==0)return 1;
        else{
            char[] tmp = s.toCharArray();
            for(int i =0; i<s.length()-1;i++){
                if(tmp[i]==tmp[i+1]){
                    return solution(s.substring(0,i)+s.substring(i+2));
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Jjak a = new Jjak();
        System.out.println(
                a.solution("aabbaab"));
    }
}
