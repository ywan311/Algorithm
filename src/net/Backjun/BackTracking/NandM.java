package net.Backjun.BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class NandM {
    static int N;
    static int M;
    static ArrayList<String> answer = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);


        for(int i=1;i<N+1;i++){
            DFS("",i,0);
        }
        for(String s:answer)bw.write(s+"\n");

        bw.flush();
    }
    static void DFS(String s,int current,int depth) {
        String result = s+current+" ";
        if(++depth==M){
            answer.add(result);
            return;
        }
        for(int i=current;i<N+1;i++){
                DFS(result,i,depth);

        }
    }
}
