package net.Programmers.practice;

public class PrimeNumber {
    public int solution(int n) {
        int answer = n-1;
        boolean check[] = new boolean[n+1];
        for(int i=2;i<=n;i++){
            if(check[i]){
                continue;
            }else{
                for(int j =i;j<=n;j+=i){
                    if(check[j])continue;
                    check[j]=true;
                    if(i!=j)answer--;
                    System.out.println(j);
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(new PrimeNumber().solution(10));
    }
}
