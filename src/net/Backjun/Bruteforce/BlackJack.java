package net.Backjun.Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BlackJack {
    static int N;
    static int M;
    static int[] arr;
    static boolean flag = false;
    static int answer=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        arr = new int[N];
        String[] arrStr = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        for(int i=0;i<arr.length&&!flag;i++){
            getSum(i,0,0);
        }
        System.out.println(answer);
    }
    static void getSum(int index,int sum,int depth){
        sum+=arr[index];
        System.out.println(depth+"   "+sum);
        if(sum>M||flag)return;
        if(depth==2){
            answer = Math.max(sum,answer);
            if(sum==M)flag=true;
            return;
        }
        for(int i=index+1;i<arr.length&&!flag;i++){
            getSum(i,sum,depth+1);
        }
    }

}
