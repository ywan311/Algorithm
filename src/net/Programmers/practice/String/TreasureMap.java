package net.Programmers.practice.String;

import java.util.Arrays;

public class TreasureMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        boolean[] map;
        for(int i =0;i<n;i++){
            map = new boolean[n];
            int a = arr1[i];
            int b = arr2[i];
            for(int j=0;j<n;j++){
                map[n-1-j] = (a%2==0&&b%2==0)?false:true;
                a/=2;
                b/=2;
            }
            StringBuffer tmp = new StringBuffer();
            for(boolean s:map){
                if(s)tmp.append("#");
                else tmp.append(" ");
            }
            answer[i] = tmp.toString();
        }

        return answer;
    }
    /*
    *  public String makeSharp(int n, int m) {
        if(n == 0) {
            if( m > 0) {
                String str = "";
                for(int i = 0; i < m; i++) {
                    str += " ";
                }
                return str;
            }
            else return "";
        }
        else {
            return n % 2 == 0 ? makeSharp(n/2, m-1) + " " : makeSharp(n/2, m-1) + "#";
        }
    }
    public String[] solution(int n, int [] arr1, int [] arr2) {
        String [] answer = new String[n];
        int [] secretMap = new int[n];
        for(int i = 0; i < n; i++) {
            secretMap[i] = arr1[i] | arr2[i];
            answer[i] = makeSharp(secretMap[i], n);
        }
        return answer;
    }
    * */
    public static void main(String[] args){
        System.out.println(Arrays.toString((new TreasureMap().solution(5,new int[]{9, 20, 28, 18, 11},new int[] {30, 1, 21, 17, 28}))));
    }
}
