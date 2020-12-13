package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class P5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            int m = Integer.parseInt(br.readLine());
            String[] input = new String[m];
            for(int i=0;i<m;i++)input[i]=br.readLine();

            Arrays.sort(input,(o1, o2) -> o1.length()-o2.length());
            boolean flag = true;
            for(int i =0;i<input.length-1;i++){
                for(int j=i+1;j<input.length;j++){
                    if(input[j].startsWith(input[i])){
                        flag=false;
                        break;
                    }
                }
            }
            System.out.println(flag?"YES":"NO");

        }
    }
}

 class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[10001];

        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<10001;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        System.out.println(arr[n]);
    }
}
