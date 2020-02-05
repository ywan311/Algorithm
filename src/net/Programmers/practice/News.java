package net.Programmers.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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

    /*List list1 = subset(str1.toLowerCase());
    List list2 = subset(str2.toLowerCase());

    int intersection = 0;

    List<Integer> check = new ArrayList<Integer>(); // 교집합 구할 떄, 중복제거

        for (int a = 0; a < list1.size(); a++) { // 교집합 개수 구하기
        String s1 = (String) list1.get(a);
        for (int b = 0; b < list2.size(); b++) {
            String s2 = (String) list2.get(b);
            if (s1.equals(s2) && !check.contains(b)) {
                intersection++;
                check.add(b);
                break;
            }

        }
    }

    int union = list1.size() + list2.size() - intersection; // 합집합

        if (union == 0 && intersection == 0) {
        return 65536;
    }

        return (int) (((float) intersection / union) * 65536);
}

    List subset(String s) { // 문자열 s의 다중집합

        List<String> list = new ArrayList<String>();
        char[] arr = s.toCharArray();
        int size = arr.length - 1;
        String str;
        int start = 0;
        int end = 1;

        while (end <= size) {
            str = String.valueOf(arr[start]) + String.valueOf(arr[end]);
            boolean isMatch = Pattern.matches("^[a-z]*$", str); // 부분집합의 원소가 영어로만 구성되어 있는지 확인
            if (isMatch) {
                list.add(str);
            }
            start++;
            end++;
        }
        return list;
    }*/
    public static void main(String[] args) {
        String s="";
        for(int i =0; i <500; i ++){
            s +="ar";
        }
        System.out.println(new News().solution(s, "arrrr"));
    }
}
