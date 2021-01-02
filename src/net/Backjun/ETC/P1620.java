package net.Backjun.ETC;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class P1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sizeArr = br.readLine().split(" ");
        int m = Integer.parseInt(sizeArr[0]);
        int n = Integer.parseInt(sizeArr[1]);
        Map<Integer,String> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        while(m-->0){
            String value = br.readLine();
            int key = map1.size()+1;
            map1.put(key,value);
            map2.put(value,key);
        }
        while(n-->0){
            String value = br.readLine();
            if(map2.containsKey(value)){
                bw.write(String.valueOf(map2.get(value)));
            }
            else bw.write(map1.get(Integer.parseInt(value)));

            bw.write("\n");
        }
        bw.flush();


    }
}
