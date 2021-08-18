package net.Programmers;

public class NumberEnglish {
    public int solution(String s) {
        String[][] arr = new String[][]{{"zero","0"},{"one","1"},{"two","2"},{"three","3"},{"four","4"},{"five","5"},{"six","6"},{"seven","7"},{"eight","8"},{"nine","9"}};
        for (String[] element : arr) {
            s = s.replaceAll(element[0], element[1]);
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        System.out.println(new NumberEnglish().solution("23four5six7"));
    }
}
