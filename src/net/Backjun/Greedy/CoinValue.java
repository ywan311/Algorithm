package net.Backjun.Greedy;

import java.util.Scanner;

public class CoinValue {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int answer=0;

        int n = input.nextInt();//동전의 종류 개수
        int k = input.nextInt();//만들 숫자
        int[] coinArr = new int[n];// 동전의 종류

        for(int i=0;i<n;i++){
            coinArr[i] = input.nextInt();
        }
        for(int i=n-1;i>=0&&k>0;i--){
            if(coinArr[i]<=k){
                answer += k/coinArr[i];
                k %=coinArr[i];
            }
        }
        System.out.println(answer);

    }
}
