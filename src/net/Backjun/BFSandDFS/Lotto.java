package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Lotto {
    static int N;
    static int[] arr;
    static int[] result;
    static ArrayList<ArrayList<Integer>> answerList;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String str[] = br.readLine().split(" ");

            N = strToInt(str[0]);
            arr = new int[N];
            result = new int[N];
            if(N==0)break;

            for(int i=0;i<N;i++){
                arr[i] = strToInt(str[i+1]);
            }
            answerList = new ArrayList<>();
            DFS(0,0);
            for(ArrayList<Integer> a:answerList){
                for(int i:a){
                    System.out.print(i+" ");
                }
                System.out.println();
            }
            System.out.println();
        }

    }
    public static void DFS(int start,int depth){
        if(depth==6){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<N;i++){
                if(result[i]==1)
                    list.add(arr[i]);
            }
            answerList.add(list);
        }
        for(int i=start;i<N;i++){
                result[i]=1;
                DFS(i+1,depth+1);
                result[i]=0;
         }

    }
    public static int strToInt(String s){
        return Integer.parseInt(s);
    }

}
