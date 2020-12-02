package net.Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BodySize {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[][] arr = new int[size][2];
        int[] answer = new int[size];

        for(int i=0;i<size;i++){
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);

            answer[i] =1;
        }
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(arr[i][0]>arr[j][0] && arr[i][1]>arr[j][1])answer[j]++;
            }
        }

        System.out.println(Arrays.toString(answer));


    }
}
