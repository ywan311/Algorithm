package net.Backjun.Combination;

import java.math.BigInteger;
import java.util.Scanner;

public class GetC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int tmp = Math.min(m,Math.abs(n-m));
        BigInteger a = BigInteger.valueOf(n);
        BigInteger b = BigInteger.valueOf(tmp);
        for (int i=1;i<tmp;i++){
            a = a.multiply(BigInteger.valueOf(n-i));
            b = b.multiply(BigInteger.valueOf(i));
        }
        System.out.println(a.divide(b));
    }
}
