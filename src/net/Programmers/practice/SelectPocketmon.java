package net.Programmers.practice;

import java.util.ArrayList;

public class SelectPocketmon {
    public int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : nums){
            if(!arrayList.contains(i))arrayList.add(i);
        }
        if(nums.length/2>arrayList.size())return arrayList.size();
        else return nums.length/2;
    }
}
