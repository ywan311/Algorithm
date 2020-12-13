package net.Backjun;

import java.io.*;
import java.util.Arrays;

public class P2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());


        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for(int i: arr){
            bw.write(String.valueOf(i));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
