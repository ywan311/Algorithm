package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//미완성
public class IsBGraph {
    static boolean[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cas = Integer.parseInt(br.readLine());
        for(;cas>0;cas--){
            String str[] = br.readLine().split(" ");
            int node = Integer.parseInt(str[0]);
            int edge = Integer.parseInt(str[1]);
            arr = new boolean[node][node];
            for(;edge>0;edge--){
                String[] s = br.readLine().split(" ");
                arr[Integer.parseInt(s[0])-1][Integer.parseInt(s[1])-1]= arr[Integer.parseInt(s[1])-1][Integer.parseInt(s[0])-1]=true;
            }
            if(node-1!=edge){
                System.out.println("NO");
                continue;
            }
            solve();
        }
    }
    static void solve(){
        for(boolean[] a:arr)System.out.println(Arrays.toString(a));
        System.out.println("------------------------");
        return;

    }
}
