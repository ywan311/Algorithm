package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11444 {
    static long mod = 1000000007L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long[][] matrix = new long[][]{{1, 1}, {1, 0}};
        long[][] answer = new long[][]{{1, 0}, {0, 1}};


        while (N>0L) {
            if(N % 2 == 1){
                answer = multiply(answer,matrix);
            }
            matrix = multiply(matrix,matrix);
            N /=2;
        }
        System.out.println(answer[0][1]);
    }

    static long[][] multiply(long[][] a1, long[][] a2) {
        return new long[][]{
                {(a1[0][0] * a2[0][0] + a1[0][1] * a2[1][0])%mod
                        , (a1[0][0] * a2[0][1] + a1[0][1] * a2[1][1])%mod},
                {(a1[1][0] * a2[0][0] + a1[1][1] * a2[1][0])%mod
                        , (a1[1][0] * a2[0][1] + a1[1][1] * a2[1][1])%mod}};
    }
}
