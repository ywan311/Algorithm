package net.Programmers.practice;

public class DividePlus {
    public int solution(int n) {
        int answer = 0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                answer += i==n/i? i: i+n/i;
                System.out.println(i);
            }
        }
        return answer/2;
    }
    public static void main(String[] args){
        System.out.println(new DividePlus().solution(16));
    }
}
