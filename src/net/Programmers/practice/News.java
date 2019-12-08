package net.Programmers.practice;

import java.util.ArrayList;

public class News {
    public int solution(String str1, String str2) {
        ArrayList<String> s1 = toList(str1);
        ArrayList<String> s2 = toList(str2);
        int gyo = 0;
        ArrayList<String> set = new ArrayList<>();
        if (s1.size() > s2.size()) {
            for (String s : s1) {
                set.add(s);
            }
            for (String s : s2) {
                if (set.contains(s)) gyo++;
                else set.add(s);
            }
        } else {
            for (String s : s2) {
                set.add(s);
            }
            for (String s : s1) {
                if (set.contains(s)) gyo++;
                else set.add(s);
            }
        }
        int hap = set.size();
        hap = hap==0&&gyo==0?1:hap;
        gyo = gyo==0?1:gyo;

        double result = (double) gyo / (double) hap * 65536;
        return (int) result;
    }

    public ArrayList<String> toList(String str) {
        char[] arr = str.toCharArray();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (((arr[i] >= 'A' && arr[i] <= 'Z') || (arr[i] >= 'a' && arr[i] <= 'z')) && ((arr[i + 1] >= 65 && arr[i + 1] <= 'Z') || (arr[i + 1] >= 'a' && arr[i + 1] <= 'z'))){
                StringBuffer buffer = new StringBuffer();
                char tmp = arr[i] >= 'A' && arr[i] < 'a' ? (char) (arr[i] + 32) : arr[i];
                buffer.append(tmp);
                char tmp2 = arr[i + 1] >= 'A' && arr[i + 1] < 'a' ? (char) (arr[i + 1] + 32) : arr[i + 1];
                buffer.append(tmp2);
                arrayList.add(buffer.toString());
            }
            else continue;
        }
        return arrayList;
    }

    public static void main(String[] args) {
        String s="";
        for(int i =0; i <500; i ++){
            s +="ar";
        }
        System.out.println(new News().solution(s, "arrrr"));
    }
}
