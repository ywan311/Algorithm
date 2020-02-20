package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StartLink {
    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static Set<Integer> set = new HashSet<>();
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        F=Integer.valueOf(str[0]);
        S=Integer.valueOf(str[1]);
        G=Integer.valueOf(str[2]);
        U=Integer.valueOf(str[3]);
        D=Integer.valueOf(str[4]);



        if (S<G)answer =Up(S,0);
        else if(S>G)answer =Down(S,0);

        if(answer>-1)System.out.println(answer);
        else System.out.println("use the stairs");

    }
    static int Up(int start,int cnt){
        if(U==0||set.contains(start)){
            return -1;
        }
        set.add(start);
        if(start==G)return cnt;
        else if(start>G||(start<=F&&start+U>F))return Down(start-D,cnt+1);
        else return Up(start+U,cnt+1);
    }
    static int Down(int start,int cnt) {
        if (D == 0 || set.contains(start)) {
            return -1;
        }
        set.add(start);
        if (start == G) return cnt;
        else if (start < G || (start > 0 && start - D < 0)) return Up(start+U, cnt+1);
        else return Down(start - D, cnt + 1);
    }
}
