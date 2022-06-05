package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1041 {
    static int[] arr = new int[6];
    static int[][] candidateTwo = new int[][]{{0, 1},{0, 2},{0, 3},{0, 4},{1, 2},{1,3},{1,5},{2,4},{2,5},{3,4},{3,5},{4,5}};
    static int[][] candidatethree = new int[][]{{0,1,2},{0,1,3},{0,2,4},{0,3,4},{1,2,5},{1,3,5},{2,4,5},{3,4,5}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        String[] input = br.readLine().split(" ");

        for(int i =0;i<input.length;i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        if(N==1){
            int max = 0;
            int sum = 0;
            for(int i :arr){
                sum+=i;
                max = Math.max(max,i);
            }
            System.out.println(sum-max);
            return;
        }

        int threeSideMin = getMinCube(3);
        int twoSideMin = getMinCube(2);
        int oneSideMin = getMinCube(1);

        long answer = threeSideMin*4L;
        answer += twoSideMin*(N*8L-12);
        answer += oneSideMin*(N-2L)*(5L*N-6L);

        System.out.println(answer);

    }
    static int getMinCube(int sideCount){
        if(sideCount==1){
            int min = 51;
            for(int i =0;i<6;i++){
                min = Math.min(min,arr[i]);
            }
            return min;
        }else if(sideCount==2){
            int min = Integer.MAX_VALUE;

            for (int[] candidate : candidateTwo) {
                min = Math.min(arr[candidate[0]] + arr[candidate[1]], min);
            }
            return min;
        }else{
            int min = 153;
            for (int[] candidate : candidatethree) {
                min = Math.min(arr[candidate[0]] + arr[candidate[1]]+arr[candidate[2]], min);
            }
            return min;
        }
    }
}
