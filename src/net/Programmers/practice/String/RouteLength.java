package net.Programmers.practice.String;

import java.util.*;

public class RouteLength {
    public int solution(String dirs) {
        int answer = 0;
        Map<Character,int[]> map = new HashMap<>();
        boolean arr[][][][] = new boolean[11][11][11][11];
        map.put('U',new int[]{0,1});
        map.put('D',new int[]{0,-1});
        map.put('L',new int[]{-1,0});
        map.put('R',new int[]{1,0});
        Dot current = new Dot(0,0);
        for(char c:dirs.toCharArray()){
            int[] n = map.get(c);
            Dot next =new Dot(current.x+n[0],current.y+n[1]);
            if(next.x<-5||next.y<-5||next.x>5||next.y>5)continue;
            if(!arr[current.x+5][current.y+5][next.x+5][next.y+5]){
                arr[current.x+5][current.y+5][next.x+5][next.y+5]=true;
                arr[next.x+5][next.y+5][current.x+5][current.y+5]=true;
                answer++;
            }
            current = next;
        }
        return answer;
    }
    class Dot{
        int x;
        int y;
        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        System.out.println(new RouteLength().solution("LULLLLLLU"));
    }
}
