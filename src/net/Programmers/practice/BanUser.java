package net.Programmers.practice;

import java.util.*;

public class BanUser{
    static String[] users;
    static String[] banUser;
    static ArrayList<String>[] result;
    static Set<String> tmp = new HashSet<>();
    static Set<Set<String>> set = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {

        users = user_id;
        banUser = banned_id;
        result = (ArrayList<String>[]) new ArrayList[banned_id.length];
        for (int i = 0; i < banUser.length; i++) {
            result[i] = new ArrayList<>();
            makeList(i);
        }
        System.out.println(Arrays.toString(result));
        for (int i = 0; i < result[0].size(); i++) {
            makeSum(0,i);
        }
        return set.size();
    }

    static void makeList(int index) {
        String banId = banUser[index];
        List<String> list = new ArrayList<>();
        for (String s : users) {
            if (s.length() != banId.length()) continue;
            else {
                list.add(s);
                for (int i = 0; i < s.length(); i++) {
                    if (banId.charAt(i) == '*') continue;
                    else if (banId.charAt(i) != s.charAt(i)) list.remove(s);
                }
            }
        }
        result[index].addAll(list);
    }

    static void makeSum(int r,int c) {
        if (tmp.contains(result[r].get(c))) return;
        tmp.add(result[r].get(c));
        if (r >= result.length - 1) {
            set.add(tmp);
            System.out.println(set);
            tmp.remove(result[r].get(c));
            return;
        }
        for (int i = 0; i < result[r + 1].size(); i++) {
            makeSum(r+1,i);
        }
        tmp.remove(result[r].get(c));
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] user_id = {  "abc121", "abc124", "abc122", "abc123", "frodoc"  };
        String[] banned_id = { "******", "******" };
        System.out.println(new BanUser().solution(user_id,banned_id));
    }

}