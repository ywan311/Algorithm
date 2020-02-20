package net.Backjun.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class StartLink {
    static int[][] arr;
    static int N;
    static boolean[] intArr;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        intArr = new boolean[N];
        for(int i=0;i<N;i++){
            String str[] = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        makeTeam(0,0);

        System.out.println(answer);

    }
    static void makeTeam(int n,int depth){
        if(depth==(N-1)/2){
            search();
            return;
        }
        intArr[n] =true;
        for(int i=n+1;i<N;i++){
            if(intArr[i]!=true){
                intArr[i]=true;
                makeTeam(i,depth+1);
                intArr[i]=false;
            }
        }
    }
    static void search(){
        int a=0;
        int b=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==j||intArr[i]!=intArr[j])continue;
                if(intArr[i]==true){
                    a+=arr[i][j];
                }
                if(intArr[i]==false){
                    b+=arr[i][j];
                }
            }
        }
        answer = Math.min(answer,Math.abs(a-b));

    }
}
