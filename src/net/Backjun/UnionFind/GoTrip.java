package net.Backjun.UnionFind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GoTrip {
    static int N;
    static int M;
    static int parents[];
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        M = Integer.parseInt(br.readLine());

        for(int i=1;i<=N;i++)parents[i]=i;

        for(int i=0;i<N;i++){
            String[] str = br.readLine().split(" ");
            for(int j=0;j<N;j++)if(str[j].equals("1"))Union(i+1,j+1);
        }
        int dest[] = new int[M];
        String[] input = br.readLine().split(" ");
        for(int i=0;i<dest.length;i++)dest[i] = Integer.parseInt(input[i]);


        for(int i=0;i<dest.length-1;i++){
            if(!find(dest[i],dest[i+1])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
    static boolean find(int a, int b){
        if(getParents(a)==getParents(b))return true;
        else return false;

    }
    static void Union(int a, int b){
        int parents1 = getParents(a);
        int parents2 = getParents(b);
        if(parents1<=parents2)parents[parents2]=parents1;
        else parents[parents1]=parents2;
    }
    static int getParents(int a){
        if(parents[a]==a)return a;
        else return parents[a] = getParents(parents[a]);
    }
}
