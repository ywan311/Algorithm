package net.Programmers.practice;

import java.util.*;

public class ShuttelBus {
    static int[] arr= new int[1441];
    public String solution(int n, int t, int m, String[] timetable) {
        String answer="00:00";
        int total = n*m;
        int start = 9*60;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++)list.add(timeInt("09:00")+i*t);
        Arrays.sort(timetable);
        int curCnt=0;
        int curBus=0;
        int[] busCnt = new int[n];
        int index=0;
        while(!list.isEmpty()){
            curBus = list.removeFirst();

        }
        return answer;
    }
    static String timeString(int n){
        String s = n/60<10?"0"+n/60+":":n/60+":";
        s+= n%60<10?"0"+n%60:String.valueOf(n%60);
        return s;
    }
    static int timeInt(String str){
        String s[] = str.split(":");
        return Integer.parseInt(s[0])*60+Integer.parseInt(s[1]);
    }
    public static void main(String[] args){
        System.out.println(new ShuttelBus().solution(10, 60, 2, new String[]{"18:00","17:00","17:00"}));
    }
}
