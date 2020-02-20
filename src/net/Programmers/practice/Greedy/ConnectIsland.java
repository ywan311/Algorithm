package net.Programmers.practice.Greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConnectIsland {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[][] arr = new int[n][n];
        int min =Integer.MAX_VALUE;
        int[] minIndex = new int[2];
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<costs.length;i++){
            arr[costs[i][0]][costs[i][1]]=arr[costs[i][1]][costs[i][0]]= costs[i][2];
            if(min>costs[i][2]){
                min = costs[i][2];
                minIndex[0] = costs[i][0];
                minIndex[1] = costs[i][1];
            }
        }
        while(set.size()<n){
            answer+=min;
            set.add(minIndex[0]);
            set.add(minIndex[1]);
            min = Integer.MAX_VALUE;

            for(int i=0;i<n;i++){
                if(set.contains(i)){
                    for(int j=0;j<n;j++){
                        if(!set.contains(j)&&arr[i][j]!=0&&arr[i][j]<min){
                            min = arr[i][j];
                            minIndex[0] = i;
                            minIndex[1] = j;
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new ConnectIsland().solution(4, new int[][]{{0,1,1},{2,3,1},{1,2,2}}));
    }
}
