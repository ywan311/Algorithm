package net.Backjun.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class DeudBo {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int first = Integer.parseInt(size[0]);
        Set<String> set1 = new TreeSet<>();
        while(first-->0)set1.add(br.readLine());

        int second = Integer.parseInt(size[1]);
        Set<String> set2 = new TreeSet<>();
        while(second-->0){
            String value = br.readLine();
            if(set1.contains(value))set2.add(value);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(set2.size()+"\n");
        for(String s:set2)bw.write(s+"\n");
        bw.flush();
    }
}
