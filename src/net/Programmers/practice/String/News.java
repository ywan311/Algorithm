package net.Programmers.practice.String;

import java.util.ArrayList;

public class News {
    public int solution(String str1, String str2) {
        ArrayList<String> s1 = toList(str1);
        ArrayList<String> s2 = toList(str2);
        System.out.println(s1);
        System.out.println(s2);
        if(s1.size()==0&&s2.size()==0)return 65536;
        double gyo = getGyo(s1,s2);
        double hap = getHap(s1,s2);
        System.out.println(gyo+"/"+hap);
        double result =  gyo /  hap * 65536;
        return (int) result;
    }

    public ArrayList<String> toList(String str) {
        char[] arr = str.toCharArray();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            char current = Character.toLowerCase(arr[i]);
            char current2 = Character.toLowerCase(arr[i + 1]);
            if (((current >= 'a' && current <= 'z')) && (current2 >= 'a' && current2 <= 'z')) {
                StringBuffer buffer = new StringBuffer();
                buffer.append(current);
                buffer.append(current2);
                arrayList.add(buffer.toString());
            } else continue;
        }
        return arrayList;
    }
    static int getGyo(ArrayList<String> s1,ArrayList<String> s2){
        s1 = (ArrayList<String>) s1.clone();
        s2 = (ArrayList<String>) s2.clone();
        ArrayList<String> gyo = new ArrayList<>();

        for(String s: s1){
            if(s2.contains(s)){
                gyo.add(s);
                s2.remove(s);
            }
        }
        return gyo.size();

    }
    static  int getHap(ArrayList<String> s1,ArrayList<String> s2){
        s1 = (ArrayList<String>) s1.clone();
        s2 = (ArrayList<String>) s2.clone();
        ArrayList<String> hap = new ArrayList<>();

        for(String s: s1){
            if(s2.contains(s)){
                s2.remove(s);
            }
            hap.add(s);
        }
        hap.addAll(s2);
        return hap.size();
    }

    public static void main(String[] args) {
        System.out.println(new News().solution("FRANCE","french"));
    }
}
