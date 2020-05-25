package net.Backjun.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RemoteControl {
    static boolean isOk[] = new boolean[10];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력
        int dest = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        String input[] = n>0?br.readLine().split(" "):null;
        while(n-->0)isOk[Integer.parseInt(input[n])]=true;
        //로직
        if(dest==100){
            System.out.println(0);
            return;
        }
        int answer = Math.abs(dest-100);
        for(int i=0;i<1000000;i++){
            int tmpAnswer=0;
            if(isPo(i)){
                System.out.println(i);
                 tmpAnswer=Math.abs(dest-i);
            }else continue;
            int l = i;
            while(l>0){
                tmpAnswer++;
                l/=10;
            }
            if(i==0)tmpAnswer++;
            answer = Math.min(answer, tmpAnswer);
        }
        System.out.println(answer);
    }
    static boolean isPo(int value){
        if(value==0)return !isOk[0];
        while(value>0){
            if(isOk[value%10])return false;
            value/=10;
        }
        return true;
    }
}
