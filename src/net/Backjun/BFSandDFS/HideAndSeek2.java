package net.Backjun.BFSandDFS;

import java.util.*;

public class HideAndSeek2 {
    static int[] arr;
//    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        arr = new int[100001];
        Arrays.fill(arr,-1);
//        answer = seek3(n,k);
        int a[] = seek2(n,k);
        System.out.println(a[0]+"\n"+a[1]);
    }
    static int[] seek2(int n, int k){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n,0});
        arr[n] =0;
        int cnt =0;

        return new int[]{arr[k],cnt};
    }
    static int seek3(int n, int k){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        arr[n]=0;

        while(!queue.isEmpty()&&arr[k]==-1){
            int current = queue.poll();
            int tmp =current*2;
            while(tmp<arr.length&&arr[tmp]==-1){
                arr[tmp] =arr[current];
                queue.add(tmp);
                tmp*=2;
            }
            if(current+1<=100000&&arr[current+1]==-1){
                arr[current+1]= arr[current]+1;
                queue.add(current+1);
            }
            if(current-1>=0&&arr[current-1]==-1){
                arr[current-1]=arr[current]+1;
                queue.add(current-1);
            }
        }
        return arr[k];
    }
}
