package net.Programmers.practice.String;

import java.util.ArrayList;
import java.util.List;

public class BrianThink {
    static List<String> list = new ArrayList<>();
    static boolean isPos = true;

    public String solution(String sentence) {
        String answer = "";
        case1(sentence);
        if (!isPos) return "invalid";
        for (int i = 0; i < list.size(); i++)
            answer += i == list.size() - 1 ? list.get(i) : list.get(i) + " ";

        return answer;
    }

    static void case1(String str) {
        try {
            String tmp = "";
            if (str.charAt(0) == str.charAt(str.length() - 1)) {
                tmp = str.substring(1, str.length() - 1);
                case2(tmp);
                return;
            } else {
                int index = 0;
                for (int i = str.length() - 2; i > 1; i--) {
                    if (str.charAt(i) == str.charAt(0)) {
                        index = i;
                        break;
                    }
                }
                if (index != 0) {
                    tmp = str.substring(1, index);
                    str = str.substring(index + 1);
                    case1(str);
                    case2(tmp);
                    return;
                }
                for (int i = 1; i < str.length() - 2; i++) {
                    if (str.charAt(i) == str.charAt(str.length() - 1)) {
                        index = i;
                        break;
                    }
                }
                if (index != 0) {
                    tmp = str.substring(index + 1, str.length() - 1);
                    str = str.substring(0, index);
                    case1(str);
                    case2(tmp);
                    return;
                }
                case2(str);
            }
        } catch (Exception e) {
            isPos = false;
            return;
        }

    }

    static void case2(String str) {
        if (str.charAt(1) != str.charAt(3)) {
            list.add(str);
            return;
        }
        String[] arr = str.split(String.valueOf(str.charAt(1)));
        StringBuilder builder = new StringBuilder();
        boolean flag=false;
        if(arr[arr.length-1].length()>1)flag=true;
        if(str.length()/2+1!=arr.length&&!flag){
            isPos=false;
            return;
        }
        for (int i=0;i<arr.length;i++) {
            if(flag&&i==arr.length-1)break;
            if (arr[i].length() != 1) {
                isPos = false;
                return;
            }
            builder.append(arr[i]);
        }
        if(flag)builder.append(arr[arr.length-1].charAt(0));
        list.add(builder.toString());
        if(flag)case1(arr[arr.length-1].substring(1));
    }

    public static void main(String[] args) {
        System.out.println(new BrianThink().solution("AcAcABaBaB"));
    }
}
