package net.Backjun.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RenderHTML {
    static StringBuilder hr = new StringBuilder();
    static StringBuilder builder = new StringBuilder();
    static int strLength=0;

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        for (int i = 0; i < 80; i++) hr.append("-");
        while ((str = input.readLine()) != null) filter(str);
        output.write(builder.toString());

    }

    static void filter(String str) throws Exception{
        String[] arr = str.split(" |    ");
        for (String s : arr) {
            if (s.trim().length() == 0) continue;
            if (s.equals("<br>")) {
                builder.append("\n");
                strLength=0;
            } else if (s.equals("<hr>")) {
                if (strLength > 0) builder.append("\n");
                builder.append(hr + "\n");
                strLength=0;
            } else if (strLength + s.length() + 1 > 80) {
                builder.append("\n");
                builder.append(s + " ");
                strLength=s.length()+1;
            } else {
                builder.append(s + " ");
                strLength+=s.length()+1;
            }
        }
    }
}
