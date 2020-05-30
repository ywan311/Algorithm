package net.Backjun.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Croatia {
    static String[] pattern = new String[]{"c=","c-","dz=","d-","lj","nj","s=","z="};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for(String p:pattern)s=s.replaceAll(p,"1");
        System.out.println(s.length());
    }
}
