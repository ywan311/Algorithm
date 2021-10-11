package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class P1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        Integer[] arr1 = new Integer[size];
        Integer[] arr2 = new Integer[size];

        String[] arrStr1 = br.readLine().split(" ");
        String[] arrStr2 = br.readLine().split(" ");
        for(int i=0;i<size;i++){
            arr1[i] = Integer.parseInt(arrStr1[i]);
            arr2[i] = Integer.parseInt(arrStr2[i]);
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());

        int answer = 0;

        for (int i=0;i<size;i++){
            answer += arr1[i]*arr2[i];
        }
        System.out.println(answer);
    }
}
