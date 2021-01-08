package net.Backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class P10814 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String[]> list = new ArrayList<>();

        int size = Integer.parseInt(br.readLine());

        while(size-->0){
            String[] input = br.readLine().split(" ");
            list.add(new String[]{input[0],input[1]});
        }
        list.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].equals(o2[0]))return 1;
                else return o1[0].compareTo(o2[0]);
            }
        });

        for(String[] a: list)bw.write(a[0]+" "+a[1]+"\n");
    }
}
