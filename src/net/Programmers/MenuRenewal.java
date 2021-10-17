package net.Programmers;

import java.util.*;

/*
 * 2021 KAKAO BLIND RECRUITMENT 메뉴 리뉴얼
 * */
public class MenuRenewal {
    static List<String>[] combination = (List<String>[]) new ArrayList[11];
    static int maxLength;
    static List<String> answer = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < 11; i++) {
            combination[i] = new ArrayList<>();
        }
        maxLength = course[course.length - 1];
        //조합 만들기
        for (String s : orders) {
            for (int i : course) {
                for (int j = 0; j < s.length(); j++) {
                    getCombination(i, j, String.valueOf(s.charAt(j)), s);
                }
            }
        }
        //count 세기
        for (int i : course) {
            int max = 1;
            Map<String, Integer> countMap = new HashMap<>();
            for (String a : combination[i]) {
                if (countMap.containsKey(a)) {
                    max = Math.max(max, countMap.get(a) + 1);
                    countMap.put(a, countMap.get(a) + 1);
                } else {
                    countMap.put(a, 1);
                }
            }
            for (String s : countMap.keySet()) {
                if (countMap.get(s) == max && max>1) {
                    answer.add(s);
                }
            }
            countMap.clear();
        }
        Collections.sort(answer);

        return answer.toArray(new String[answer.size()]);
    }

    void getCombination(int destinationLength, int index, String element, String total) {
        if (destinationLength > total.length()) return;
        if (destinationLength == element.length()) {
            char[] arr =element.toCharArray();
            Arrays.sort(arr);
            combination[destinationLength].add(new String(arr));
            return;
        }
        for (int i = index + 1; i < total.length(); i++) {
            getCombination(destinationLength, i, element + total.charAt(i), total);
        }
    }

    public static void main(String[] args) {
        String[] orders = new String[]{"XYZ", "XWY", "WXA"};
        int[] course = new int[]{2, 3, 4};
        System.out.println(Arrays.toString(new MenuRenewal().solution(orders, course)));
    }
}
