package net.Backjun;

import java.io.*;
import java.util.Arrays;

public class P2447 {
    static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new boolean[n][n];
        solve(0,n-1,0,n-1);

        for(boolean[] a: arr){
            for(boolean b: a){
                if(b)bw.write("*");
                else bw.write(" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
    public static void solve(int x1,int x2, int y1,int y2){
        if(x2-x1==2&&y2-y1==2){
            for(int i=x1;i<=x2;i++){
                for(int j=y1;j<=y2;j++){
                    if(i%3!=1||j%3!=1)arr[i][j]=true;
                }
            }
            return;
        }
        int pivotX = (x2-x1)/3;
        int pivotY = (y2-y1)/3;
        solve(x1,x1+pivotX,y1,y1+pivotY);
        solve(x1,x1+pivotX,y1+pivotY+1,y2-pivotY-1);
        solve(x1,x1+pivotX,y2-pivotY,y2);
        solve(x1+pivotX+1,x2-pivotX-1,y1,y1+pivotY);
        solve(x1+pivotX+1,x2-pivotX-1,y2-pivotY,y2);
        solve(x2-pivotX,x2,y1,y1+pivotY);
        solve(x2-pivotX,x2,y1+pivotY+1,y2-pivotY-1);
        solve(x2-pivotX,x2,y2-pivotY,y2);
    }
}
