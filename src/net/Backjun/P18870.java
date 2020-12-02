package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

public class P18870 {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
//        int size =1000000;
        int[] arr = new int[size];
        TreeSet<Integer> set = new TreeSet<>();



        String[] input = br.readLine().split(" ");
//        String[] input = new String[size];

//        for(int i=0;i<input.length;i++){
//            input[i] = String .valueOf((int)(Math.random()*1000000000));
//        }

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(input[i]);
            set.add(Integer.parseInt(input[i]));
        }
        while(!set.isEmpty())list.add(set.pollFirst());


        for(int i=0;i<arr.length;i++){
            binarySearch(arr[i]);
        }

    }
    private static void binarySearch(int input){
        int left =0;
        int right = list.size();


        while(left<=right){
            int mid =(left+right)/2;
            if(list.get(mid)>input)right=mid-1;
            else if (list.get(mid)<input)left=mid+1;
            else{
                System.out.print(mid+" ");
                return;
            }

        }
    }
}
