package net.Backjun;

import java.io.*;

public class P15686 {
    static int size;
    static int M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputSize = br.readLine().split(" ");
        size = Integer.parseInt(inputSize[0]);
        M = Integer.parseInt(inputSize[1]);
        arr = new int[size][size];

        for(int i =0;i<size;i++){
            String[] inputArr = br.readLine().split(" ");
            for(int j =0;j<size;j++){
                arr[i][j] = Integer.parseInt(inputArr[j]);

            }
        }

    }
}
