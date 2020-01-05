package net.Programmers.practice;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShuttleBus {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int tmp = (n-1)*t;
        int lastTime = t==1?900:(tmp/60+9)*100+tmp%60;
        int prevTime = t==1?0:((tmp-t)/60+9)*100+(tmp-t)%60;
        Arrays.sort(timetable);
        for(int i=0;i<timetable.length;i++){
            timetable[i]=timetable[i].replace(":","");
        }
        Stack<Integer> stack = new Stack<>();
        for(String s: timetable){
            int time =Integer.parseInt(s);
            if(time>prevTime&&time<=lastTime)stack.push(time);
        }
        if(stack.size()<m) return firstZero(lastTime);
        else{
            while(true){
                int lastMan = stack.pop();
                if(stack.isEmpty()){
                    if((lastMan-1)%100<60) return  firstZero(lastMan-1);
                    else{
                        return firstZero(lastMan-41);
                    }
                }
                else if(stack.size()<m&&stack.peek()<lastMan){
                    return firstZero(stack.peek());
                }
            }
        }

    }
    public String firstZero(int i){
        StringBuilder s = new StringBuilder();
        if(i/100<10)s.append("0"+i/100+":");
        else s.append(i/100+":");
        if(i%100<10)s.append("0"+i%100);
        else s.append(i%100);
        return s.toString();
    }
    public static void main(String[] args){
        System.out.println(new ShuttleBus().solution(2,10,2, new String[]{"09:10", "09:09", "08:00"}));
    }
}
