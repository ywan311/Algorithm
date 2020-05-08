package net.Programmers.practice;

import java.util.*;
import java.util.regex.Pattern;

public class MatchingScore {
    static double[] score;
    static double[] linkNum;
    static String pivot;
    static Map<String, Integer> map = new HashMap<>();
    static List<String>[] linkList;
    //기본점수 체크
    //매칭점수 계산
    public int solution(String word, String[] pages) {
        int answer = 0;
        pivot = word.toLowerCase();
        score = new double[pages.length] ;
        linkNum = new double[pages.length] ;
        linkList = (List<String>[]) new ArrayList[pages.length];
        for(int i=0;i<linkList.length;i++)linkList[i] = new ArrayList<>();
        for(int i=0;i<pages.length;i++){
            String s = pages[i];
            String body = s.split("<body>|</body>")[1];
            map.put(s.split("<meta property=\"og:url\" content=\"|\"/>")[1].replaceAll("",""),i);
            score[i] = getStandardScore(body);
            linkNum[i] = getMatchScore(body,i);
        }
        for(int i=0;i<linkNum.length;i++){
            linkNum[i] = score[i]/linkNum[i];
        }
        double max = 0.0;
        for(int i=0;i<score.length;i++){
            for(String s: linkList[i]){
                if(!map.containsKey(s))continue;
                score[map.get(s)]+=linkNum[i];
            }
        }
        for(int i=0;i<score.length;i++){
            if(max<score[i]){
                max=score[i];
                answer = i;
            }
        }

        return answer;
    }
    public int getStandardScore(String input){
        String s[] = input.split("\n|[^a-zA-Z]");
        int cnt=0;
        for(String str: s){
            if((str.toLowerCase()).equals(pivot))cnt++;
        }
        return cnt;
    }
    public int getMatchScore(String arr, int index){
        String[] find = arr.split("\n|<");
        for(String s: find){
            if(s.length()<1||s.charAt(0)!='a')continue;
            int start = s.indexOf("href=\"");
            int end = s.indexOf("\">");
            linkList[index].add(s.substring(start+6,end));
        }
        return linkList[index].size();
    }
    public static void main(String[] args) {
        System.out.println(new MatchingScore().solution("Muzi", new String[] {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"}
));
    }
}
