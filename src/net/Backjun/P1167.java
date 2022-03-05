package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1167 {

    static int max = 0;
    static ArrayList<int[]>[] arr;
    static int size;
    static int maxIndex = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        arr = new ArrayList[size+1];
        for(int i =1;i<=size;i++){
            arr[i] = new ArrayList<>();
        }

        for(int i =0;i<size;i++){
            String[] input = br.readLine().split(" ");
            int index = Integer.parseInt(input[0]);
            for(int j=0;j< input.length-2;j+=2){
                arr[index].add(new int[]{Integer.parseInt(input[j+1]),Integer.parseInt(input[j+2])});
                arr[Integer.parseInt(input[j+1])].add(new int[]{index,Integer.parseInt(input[j+2])});

            }
        }

        searchMax(1,new boolean[size+1],0);

        searchMax(maxIndex,new boolean[size+1],0);
        System.out.println(max);
    }
    static void searchMax(int index,boolean[] visited,int value){
        visited[index] = true;

        for(int[] i : arr[index]){
            if(visited[i[0]] || index == i[0]){
                continue;
            }
            if(i[1]+value>max){
                max = i[1]+value;
                maxIndex = i[0];
            }
            searchMax(i[0],visited,i[1]+value);
        }
    }

}
