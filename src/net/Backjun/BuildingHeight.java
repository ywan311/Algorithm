package net.Backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BuildingHeight {
    static int size;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        arr =new int[size];
        String[] arrElement = br.readLine().split(" ");

        for(int i=0;i<size;i++){
            arr[i] = Integer.parseInt( arrElement[i]);
        }
    }

    public int toRight(int index){
        int result =0;
        for(int i=index;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){

            }
        }

        return result;
    }

}
