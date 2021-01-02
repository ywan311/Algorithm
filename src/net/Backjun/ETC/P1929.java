package net.Backjun.ETC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1929 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        boolean[] arr = new boolean[N+1];
        for(int i=0;i<M;i++)arr[i]=true;
        arr[1]=true;
        for(int i=2;i<Math.sqrt(arr.length);i++){
            for(int j=i*2;j<arr.length;j+=i){
                arr[j]=true;
            }
        }
        for(int i =1;i<arr.length;i++){
            if(!arr[i])bw.write(i+"\n");
        }
        bw.flush();

    }
}
