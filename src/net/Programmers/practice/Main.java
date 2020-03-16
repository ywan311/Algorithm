package net.Programmers.practice;

public class Main {
    public int solution(int n, int[] money) {
        int answer = 0;
        int arr[] = new int[money.length];
        for(int i=0;i<arr.length;i++){
            if(money[i]==1)arr[i]=1;
            else arr[i] = n/money[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Main().solution(5,new int[]{1,2,5}));
    }
}
