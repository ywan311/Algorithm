package net.Backjun;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (n-- > 0) {
            String command = br.readLine();
            int length = Integer.parseInt(br.readLine());
            String arr = br.readLine().replaceAll("[\\[\\]]", "");

            try {
                String[] intArr = arr.split(",");
                if(length>0)for (String s : intArr) list.add(Integer.parseInt(s));
                boolean isFoward =true;
                for (char c : command.toCharArray()) {
                    if(c=='R')isFoward=!isFoward;
                    else{
                        if(isFoward)list.remove(0);
                        else list.remove(list.size()-1);
                    }
                }
                if(!isFoward)list.sort((o1, o2) -> -1);
                String output = list.toString().replaceAll(" ","");

                bw.write(output);
                bw.write("\n");
                list.clear();
            } catch (Exception e) {
                bw.write("error");
                bw.write("\n");
                list.clear();
            }
        }
        bw.flush();
    }
}