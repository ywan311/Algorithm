package net.Programmers.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SecondTraffic {
    public int solution(String[] lines) {
        int answer = 0;
        List<Traffic> list = new LinkedList<>();
        for (String s : lines) {
            String str[] = s.split(" ");
            long start = Long.parseLong(str[1].replaceAll("[^0-9]", ""));
            double time = Double.parseDouble(str[2].replaceAll("s", ""));
            System.out.println(start + "," + time);
            list.add(new Traffic(start, (long) ((double) start + time * 1000) - 1));
        }
        System.out.println(list);
        Traffic current;
        for (int i = 0; i < list.size(); i++) {
            current = list.get(i);
            long pivot = current.start + 999;
            long pivot2 = current.end + 999;
            long pivot3 = current.end - 999;
            long pivot4 = current.start-999;
            int tmp = 1;
            int tmp2 = 1;
            int tmp3 = 1;
            int tmp4 =1;
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                else {
                }
            }
            answer =Math.max(answer,Math.max( Math.max(tmp,tmp2),Math.max(tmp3,tmp4)));
        }

        return answer;
    }

    class Traffic {
        long start;
        long end;

        public Traffic(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Traffic{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(new SecondTraffic().solution(new String[]{
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"}));
    }
}
