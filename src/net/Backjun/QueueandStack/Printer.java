package net.Backjun.QueueandStack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Printer {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            String str[] = br.readLine().split(" ");
            int m =Integer.parseInt(str[0]);
            int target = Integer.parseInt(str[1]);
            String priority[] = br.readLine().split(" ");
            for(int i=0;i<m;i++){
                queue.offer(new int[]{Integer.parseInt(priority[i]),i});
            }
            for(int[] a: queue)System.out.println(Arrays.toString(a));
            queue.clear();
        }
    }
}
