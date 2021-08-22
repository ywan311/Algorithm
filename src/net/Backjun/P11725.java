package net.Backjun;

import java.io.*;
import java.util.*;

public class P11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] tree =new ArrayList[size+1];

        for(int i=0;i<tree.length;i++){
            tree[i] = new ArrayList<>();
        }

        int[] answer = new int[size+1];

        while(size-->1){
            String[] s = br.readLine().split(" ");
            tree[Integer.parseInt(s[0])].add(Integer.parseInt(s[1]));
            tree[Integer.parseInt(s[1])].add(Integer.parseInt(s[0]));
        }
        Queue<Integer> set = new LinkedList<>();
        set.offer(1);

        while(!set.isEmpty()){
            int current = set.poll();
            for(int i: tree[current]){
                if(answer[i]==0){
                    answer[i]=current;
                    set.offer(i);
                }
            }
        }
        for(int i=2;i<answer.length;i++){
            bw.write(answer[i]+"\n");
        }
        bw.flush();
    }
}
