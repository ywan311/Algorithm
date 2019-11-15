package com.Bostcamp.test;

import java.util.HashMap;

public class CountPair {
    public int solution(int[] arr1, int[] arr2){
        int answer=0;
        HashMap<Integer,Integer> v1 = setHashMap(arr1);
        HashMap<Integer,Integer> v2 = setHashMap(arr2);

        int[] max1 = makeMax(v1);
        int[] max2 = makeMax(v2);


        if(max1[1]>=4&&max2[1]>=4) {
            if (max1[0]>max2[0])answer=1;
            else if (max1[0]<max2[0])answer=2;
            else answer=0;}
        else if(max1[1]>max2[1]){
            answer=1;
        }else if(max1[1]==max2[1]){
            if(max1[1]==1) answer=0;
            else if (max1[0]>max2[0])answer=1;
            else if (max1[0]<max2[0])answer=2;
            else answer=0;
        }
        else answer=2;

        return answer;
    }
    public static HashMap<Integer,Integer> setHashMap(int[] arr1){
        HashMap<Integer,Integer> v = new HashMap<>();
        for(int i=0;i<arr1.length;i++){
            if(v.containsKey(arr1[i])){
                int tmp =v.get(arr1[i]);
                v.put(arr1[i],++tmp);
            }else{
                v.put(arr1[i],1);
            }
        }
        return v;
    }
    public static int[] makeMax(HashMap<Integer,Integer> v){
        int max[] = {0,0};
        for(int x : v.keySet()){
            if(v.get(x)>max[1]){
                max[0]=x;
                max[1]=v.get(x);
            }else if(v.get(x)==max[1]&&x>max[0]){
                max[0]=x;
            }
        }
        return max;
    }
    public static  void main (String[] args){
        CountPair t = new CountPair();
        int[] q1 ={1,2,2,2,2,2,5};
        int[] q2 = {4,4,4,4,5,6,7};
        System.out.println(t.solution(q1,q2));
    }
}
