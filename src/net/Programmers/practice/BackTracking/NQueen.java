package net.Programmers.practice.BackTracking;

public class NQueen {
    static int[] arr;
    static int N;
    static int answer = 0;
    public int solution(int n) {

        N=n;
        for(int i=1;i<=N;i++){
            arr = new int[N+1];
            arr[1]=i;
            DFS(1);
        }
        return answer;
    }
    static void DFS(int row){
        if(row==N){
            answer++;
            return;
        }
        for(int i=1;i<=N;i++){
            arr[row+1]=i;
            if(check(row+1)){
                DFS(row+1);
            }else arr[row+1]=0;
        }
        arr[row]=0;
    }
    static boolean check(int value){
        for(int i=1;i<value;i++){
            if(arr[i]==arr[value])return false;
            if(Math.abs(arr[i]-arr[value])==Math.abs(i-value))return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueen().solution(4));
    }
}
