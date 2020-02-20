package net.Programmers.practice.Greedy;

import java.util.HashSet;

public class TrainingClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int answer = n - lost.length;
        for(int i : reserve){
            set.add(i);
        }
        for (int i : lost){
            if(set.contains(i)){
                set.remove(i);
                answer++;
            }else{
                set2.add(i);
            }
        }
        for(int i: set2){
            if (set.contains(i-1)){
                answer++;
                set.remove(i-1);
            }
            else if (set.contains(i+1)){
                answer++;
                set.remove(i+1);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(new TrainingClothes().solution(3,new int[] {1,2},new int[]{2,3}));
    }
}
