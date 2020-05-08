package net.Backjun.Bruteforce;

public class PrintN {
    static int answer = 0;
    static int N;
    public int solution(int n) {
        N =n;
        for(int i=1;i<=n;i++){
            sumValues(i,i);
        }
        return answer;
    }
    static void sumValues(int current,int sum){
        if (sum >= N) {
            if(sum==N){
                answer++;
            }
            return;
        }
        sumValues(current+1,sum+current+1);
    }

    public static void main(String[] args) {
        System.out.println(new PrintN().solution(15));
    }
}
