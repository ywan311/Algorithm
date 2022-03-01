package net.Backjun;

import java.io.*;
import java.util.Arrays;

public class P10830 {
    static int N;
    static long B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        B = Long.parseLong(size[1]);

        int[][] arr = new int[N][N];
        int[][] answer = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] element = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(element[j]);
            }
            answer[i][i] = 1;
        }

        while (0 < B) {
            if (B % 2 == 1) {
                answer = multiply(answer, arr);
            }
            arr = multiply(arr, arr);
            B /= 2;
        }

        for(int[] a : answer){
            for(int b : a){
                bw.write(String.valueOf(b));
                bw.write(" ");
            }
            bw.write("\n");
        }
        bw.flush();


    }

    static int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum % 1000;
            }
        }
        return result;
    }
}
