package net.Programmers.practice.ExhaustiveSearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPrimeNumber {
    static int answer =0;
    static Set<Integer> set = new HashSet<>();
    static int[] arr;
    static boolean[] visited;
    public int solution(String numbers) {
        arr = new int[numbers.length()];
        visited = new boolean[numbers.length()];
        for(int i=0;i<arr.length;i++){
            arr[i] = numbers.charAt(i)-'0';
        }
        for(int length =1; length<=numbers.length();length++){
            Arrays.fill(visited,false);
            for(int i=0;i<numbers.length();i++){
                visited[i]=true;
                getNumber(arr[i],length,1);
                visited[i]=false;
            }
        }
        return answer;
    }
    static void getNumber(int value,int length,int current){
        if(length==current){
           if(!set.contains(value)){
               set.add(value);
               if(isPrime(value))answer++;
           }
           return;
        }
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i] =true;
                getNumber(value*10+arr[i],length,current+1);
                visited[i] =false;
            }
        }
    }
    static boolean isPrime(int value){
        int n=2;
        if(value<2)return false;
        while(n<value){
            if(value%n==0)return false;
            n++;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new FindPrimeNumber().solution("7011"));
    }

}
