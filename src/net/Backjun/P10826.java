package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P10826 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());

        BigInteger modValue = new BigInteger("1000000007");
        BigInteger a1=BigInteger.ZERO;
        BigInteger a2=BigInteger.ONE;
        BigInteger tmp;
        for(long i=2;i<=n;i++){
            tmp = a1.add(a2).mod(modValue);
            a1 = a2;
            a2 = tmp;

        }
        System.out.println(a2);
    }
}
