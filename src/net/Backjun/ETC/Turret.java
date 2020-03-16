package net.Backjun.ETC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Turret {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int loop = Integer.parseInt(br.readLine());
        while(loop-->0){
            String[] str = br.readLine().split(" ");
            int answer =solve(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2]),Integer.parseInt(str[3]),Integer.parseInt(str[4]),Integer.parseInt(str[5]));
            bw.write(answer+"\n");
        }
        bw.flush();

    }
    static int solve(int x1,int y1,int r1,int x2,int y2,int r2){
        if(x1==x2&&y1==y2){
            return r1==r2?-1:0;
        }
        int absX = Math.abs(x1-x2);
        int absY = Math.abs(y1-y2);
        int absR1 = Math.abs(r1+r2);
        int absR2 = Math.abs(r1-r2);
        double distance = Math.sqrt((Math.pow(absX,2)+Math.pow(absY,2)));
        if(distance>absR2&&distance<absR1)return 2;
        if(distance<absR2||distance>absR1)return 0;
        else return 1;
    }

}
