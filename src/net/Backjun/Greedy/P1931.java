package net.Backjun.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P1931 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<int[]> list = new ArrayList<>();

        int n= Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            list.add(new int[]{Integer.parseInt(str[0]),Integer.parseInt(str[1])});
        }

        list.sort((o1, o2) -> {
            if(o1[1]==o2[1])return o1[0]-o2[0];
            else return o1[1]-o2[1];
        });
        int cnt=0;
        int end=0;
        for(int[] a : list){
            if(end<=a[0]){
                end = a[1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
