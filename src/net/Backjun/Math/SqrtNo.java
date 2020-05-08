package net.Backjun.Math;

import java.util.Scanner;

public class SqrtNo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long min = input.nextLong();
        long max = input.nextLong();
        boolean check[] = new boolean[(int)(max-min+1)];



        for (long i = 2; i * i < max; i++) {
            long tmpNum = i*i;
            long start = min%tmpNum==0?min/tmpNum:(min/tmpNum)+1;

            for(long j=start;tmpNum*j<=max;j++){
                check[(int)((j*tmpNum)-min)]=true;
            }
        }
        int sum = 0;
        for (int i = 0; i < max-min; i++) {
            if (!check[i]) sum++;
        }
        System.out.println(sum);

    }
}
