package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for(int i=0;i<N;i++){
            arr[i] = br.readLine();
        }
        if(N==1){
            System.out.println(1);
            return;
        }
        int length=0;
        for(int i=0;i<arr[0].length();i++){
            char c = arr[0].charAt(i);
            boolean flag =false;
            for(int j=1;j<N;j++){
                if(arr[j].charAt(i)!=c){
                    flag=true;
                    break;
                }
            }
        }
    }
}
