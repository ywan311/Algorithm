package net.Programmers;

public class Mod1Minimum {
    public int solution2(int n) {
        int answer = 0 ;
        for(int i =2;i<n;i++){
            if(n%i==1){
                return i;
            }
        }
        return answer;
    }
}
