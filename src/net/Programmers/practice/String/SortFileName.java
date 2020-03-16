package net.Programmers.practice.String;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SortFileName {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
       Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1.split("[0-9]")[0];
                o1 = o1.replaceAll(str1, "");
                str1 = str1.toLowerCase();
                String num1 = "";
                for (int i = 0; i < o1.length() && (o1.charAt(i) >= '0' && o1.charAt(i) <= '9'); i++) {
                    num1 += o1.charAt(i);
                }
                int realNum1 = Integer.parseInt(num1);

                String str2 = o2.split("[0-9]")[0];
                o2 = o2.replaceAll(str2, "");
                str2 = str2.toLowerCase();
                String num2 = "";
                for (int i = 0; i < o2.length() && (o2.charAt(i) >= '0' && o2.charAt(i) <= '9'); i++) {
                    num2 += o2.charAt(i);
                }
                int realNum2 = Integer.parseInt(num2);
                return str1.equals(str2)?realNum1-realNum2:str1.compareTo(str2);
            }
        });
        return files;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortFileName().solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
    }
}
