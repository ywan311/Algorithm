package net.Backjun.BFSandDFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek {
    static int N;
    static int K;
    static int[] dp;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        K = input.nextInt();
        dp = new int[100005];
        Arrays.fill(dp,-1);
        System.out.println(findMan(K));
    }
    public static int findMan(int target){
        Queue<Integer> q = new LinkedList();
        int status[] = new int[3];
        if(N==target)return 0;
        int next = N;
        q.add(next);
        dp[next]=0;
        while(!q.isEmpty()&&next!=K){
            next= q.poll();
            status[0]= next-1;
            status[1]= next+1;
            status[2] = next*2;

            for(int i=0;i<3;i++){
                if(status[i]<0||status[i]>100000)continue;
                if(dp[status[i]] ==- 1){
                    q.add(status[i]);
                    dp[status[i]]=dp[next]+1;
                }
            }
        }
        return dp[K];
    }
}
