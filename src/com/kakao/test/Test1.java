package com.kakao.test;

public class Test1 {
    static int answer;
    public int solution(String s) {
        answer = s.length();
        if (s.length() % 2 == 0) compression(s, s.length() / 2);
        else compression(s, s.length()/2 + 1);

        return answer;
    }

    //압축 메소드
    public int compression(String s, int n) {
        int cnt = 1;
        String after = "";
        if (n < 1) return answer;
        else if (s.length() == 0) return 0;

        String tmp = s.substring(0, n);

        int tmpAnswer = n;


        for (int i = n; i < s.length(); i += n) {
            System.out.println(tmp);
            if (i + n - 1 < s.length()) {
                if (s.substring(i, i + n).equals(tmp)) {
                    cnt++;
                } else {
                    tmp = s.substring(i, i + n);
                    tmpAnswer +=cnt<2?n:n+String.valueOf(cnt).length();
                    cnt=0;
                }
                System.out.println(cnt+"   "+tmpAnswer);
            } else {
                tmpAnswer += s.length() - i;
            }
            if (tmpAnswer > answer) return compression(s, n - 1);
        }
        if (n == 1) return answer = tmpAnswer;
        else {
            answer = tmpAnswer;
            return compression(s, n - 1);
        }
    }

    public static void main(String args[]) {
        Test1 test1 = new Test1();
        System.out.println(test1.solution("abcabcabcabcdededededede"));
    }
}