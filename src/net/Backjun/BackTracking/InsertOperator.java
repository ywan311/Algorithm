package net.Backjun.BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InsertOperator {
    static int N;
    static int[] arr;
    static int[] operator = new int[4];
    static int max =Integer.MAX_VALUE*-1;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());
        arr = new int[N];
        String str[] = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        String str2[] = br.readLine().split(" ");
        for(int i=0;i<4;i++){
            operator[i] = Integer.parseInt(str2[i]);
        }
        System.out.println(Arrays.toString(operator));
        DFS(1,arr[0]);

        System.out.println(max);
        System.out.println(min);

    }
    static void DFS(int index, int result){
        System.out.println(index+"  "+ result);
        if(index==N){
            max =Math.max(max,result);
            min =Math.min(min,result);
            return;
        }

        for(int i=0;i<4;i++){
            if(operator[i]>0){
                operator[i]--;
                switch (i){
                    case 0:
                        DFS(index+1,result+arr[index]);
                        break;
                    case 1:
                        DFS(index+1,result-arr[index]);
                        break;
                    case 2:
                        DFS(index+1,result*arr[index]);
                        break;
                    case 3:
                        DFS(index+1,result/arr[index]);
                        break;
                }
                operator[i]++;
            }
        }
    }
}
