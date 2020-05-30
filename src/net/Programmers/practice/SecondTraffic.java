package net.Programmers.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SecondTraffic {
    static int start[];
    static int end[];
    public int solution(String[] lines) {
        int answer=0;
        start = new int[lines.length];
        end = new int[lines.length];
        setTime(lines);
        for(int i=0;i<start.length;i++){
            int cnt =1;
            int cnt2 =1;
            int pivot =start[i]+1000;
            int pivot2 = end[i]+1000;
            for(int j=0;j<start.length;j++){
                if(i==j)continue;
                if(start[j]>=start[i]&&start[j]<pivot)cnt++;//pivot 1
                else if(end[j]>=start[i]&&end[j]<pivot)cnt++;
                else if(start[j]<=start[i]&&end[j]>=pivot)cnt++;

                if(start[j]>=end[i]&&start[j]<pivot2)cnt2++;//pivot 2
                else if(end[j]>=end[i]&&end[j]<pivot2)cnt2++;
                else if(start[j]<=end[i]&&end[j]>=pivot2)cnt2++;
            }
            answer = Math.max(answer, Math.max(cnt,cnt2));
        }

        return answer;
    }
    static void setTime(String[] lines){
        for(int i=0;i<lines.length;i++){
            String input[] = lines[i].split(" ");
            String time[] =input[1].split(":");
            int value = Integer.parseInt(time[0])*60*60*1000;
            value += Integer.parseInt(time[1])*60*1000;
            value += (int)(Double.parseDouble(time[2])*1000);

            end[i] = value;
            start[i] =1+value-(int)(Double.parseDouble(input[2].substring(0,input[2].length()-1))*1000);
        }
    }


    public static void main(String[] args) {
        System.out.println(new SecondTraffic().solution(new String[]{
                "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"}));
    }
}
