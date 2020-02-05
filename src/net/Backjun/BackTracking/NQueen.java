package net.Backjun.BackTracking;


import java.util.*;

public class NQueen {
    static int N;
    static boolean arr[][];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();

        arr = new boolean[N][N];
        int answer=0;

        for(int i=0;i<N;i++){
            for(boolean[] a:arr)Arrays.fill(a,false);
            answer+=DFS(0,i);
        }
        System.out.println(answer);
    }
    public static int DFS(int x,int y){
        for(int i=0;i<N;i++){
        }
        return 0;
    }
    public static void checkPosition(int x,int y){
        for(int i=0;i<N;i++){
            arr[x][i]=true;

        }

    }
}
