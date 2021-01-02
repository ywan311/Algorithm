package net.Backjun.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class P17219 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] size = br.readLine().split(" ");
        Map<String,String> map =new HashMap<>();
        int m = Integer.parseInt(size[0]);
        int n = Integer.parseInt(size[1]);
        while(m-->0){
            String[] input = br.readLine().split(" ");
            map.put(input[0],input[1]);
        }
        while(n-->0){
            bw.write(map.get(br.readLine()));
            bw.write("\n");
        }
        bw.flush();
    }
}
