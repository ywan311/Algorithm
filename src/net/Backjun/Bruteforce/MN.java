package net.Backjun.Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MN {
    static int M;
    static int N;
    static int[] arr;
//    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");

        M = Integer.parseInt(size[0]);
        N = Integer.parseInt(size[1]);

        arr = new int[M];
//        visited = new boolean[M];

        String str[] = br.readLine().split(" ");
        for(int i=0;i<M;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
//            visited[i] =true;
            if(!set.contains(arr[i])){
                set.add(arr[i]);
                DFS(i,1,"");
            }
//            visited[i]=false;
        }

    }
    static void DFS(int index, int length, String s){
        s += arr[index]+" ";
        Set<Integer> set = new HashSet<>();
        if(N==length){
            System.out.println(s);
            return;
        }

//       for(int i=0;i<arr.length;i++){
        for(int i=index;i<arr.length;i++){
//           if(!visited[i]){
//               visited[i] =true;
            if(!set.contains(arr[i])){
                set.add(arr[i]);
                DFS(i,length+1,s);
            }
//               visited[i] =false;
//           }
       }
    }
}
