package net.Programmers.practice;

import java.util.HashSet;
import java.util.Set;

public class MakePrime {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k= j+1;k<nums.length;k++){
                   int sum = nums[i]+nums[j]+nums[k];
                   System.out.println(i+" "+j+" "+k);
                   if(!set.contains(sum)){
                       set.add(sum);
                       if(isPrime(sum))answer++;
                   }
                }
            }
        }
        System.out.println(set);

        return answer;
    }
    static boolean isPrime(int value) {
        int n = 2;
        while (n < value) {
            if (value % n == 0) return false;
            n++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[50];
        int value =1000;
        for(int i=0;i<arr.length;i++){
            arr[i] = value--;
        }
        System.out.println(new MakePrime().solution(arr));
    }
}
