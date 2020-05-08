package net.Backjun.Dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bridge {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            String str[] = br.readLine().split(" ");
            int value1 = Math.max(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
            int value2 = Math.min(Integer.parseInt(str[0]),Integer.parseInt(str[1]));

            int gap = Math.min(value2,value1-value2);
            long result1=1;
            long result2=1;
            for(int i=0;i<gap;i++){
                result1*=(value1-i);
                result2*=i+1;
            }
            bw.write(String.valueOf(result1/result2)+"\n");
        }
        bw.flush();
    }
}
