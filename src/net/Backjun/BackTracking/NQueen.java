package net.Backjun.BackTracking;


import java.util.*;

public class NQueen {
    static int N;
    static int answer=0;
    static int arr[];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();

        for(int i=1;i<=N;i++){
            arr = new int[N+1];
            arr[1]=i;
            DFS(1);

        }
        System.out.println(answer);
    }
    static void DFS(int row){
        if(row ==N){
            answer++;
            return;
        }
        for(int i=1;i<=N;i++){
            arr[row+1]=i;
            if(checkPosition(row+1)){
                DFS(row+1);
            }
            else arr[row+1]=0;
        }
        arr[row]=0;
    }
    static boolean checkPosition(int value){
        for(int i=1;i<value;i++){
            if(arr[i]==arr[value])return false;
            if(Math.abs(arr[i]-arr[value])==Math.abs(i-value))return false;
        }
        return true;
    }

}
