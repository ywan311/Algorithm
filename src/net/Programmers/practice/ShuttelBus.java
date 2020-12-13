package net.Programmers.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShuttelBus {
    static int[] arr = new int[1441];
    static int[] sumArr = new int[1441];
    static int[] sumArr2 = new int[1441];
    static List<Integer> busList = new ArrayList<>();

    public String solution(int n, int t, int m, String[] timetable) {
        int startBus = 540;
        for (int i = 0; i < n; i++) {
            busList.add(startBus + i * t);
        }
        String answer = "00:00";
        for (String s : timetable) {
            String[] input = s.split(":");
            arr[Integer.parseInt(input[0]) * 60 + Integer.parseInt(input[1])]++;
        }

        int tmp = 0;
        int tmp2 = 0;
        for (int i = 0; i < arr.length; i++) {
            tmp += arr[i];
            tmp2 += arr[i];
            sumArr[i] = tmp;
            sumArr2[i] = tmp2;
            if (busList.contains(i)) tmp = 0;
        }
        busList.sort((o1, o2) -> o2 - o1);

        for (int i = busList.get(0); i >= 0; i--) {
            if (sumArr[i] <= m && sumArr2[i] <= m * n) {
                answer = i==1440?"23:00":String.format("%02d:%02d", i / 60, i % 60);
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new ShuttelBus().solution(2,10,3, new String[]{"09:05","09:09","09:13"}));
    }
}
