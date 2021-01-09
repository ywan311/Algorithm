package net.Backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class P10814 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] arr;

        int size = Integer.parseInt(br.readLine());

        arr = new String[size][2];
        for(int i=0;i<size;i++){
            String[] input = br.readLine().split(" ");
            arr[i]=input;
        }
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
            }
        });
        for(String[] s: arr) System.out.println(s[0]+" "+s[1]);
    }
}
