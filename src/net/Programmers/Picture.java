package net.Programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Picture {
    static Character[] members = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static Set<String> result = new HashSet<>();
    static List<String> pattern;

    public int solution(int n, String[] data) {
        boolean[] checked = new boolean[members.length];
        pattern = new ArrayList<>();
        pattern = Arrays.stream(data).collect(Collectors.toList());
        result = new HashSet<>();
        for (int i = 0; i < members.length; i++) {
            checked[i] = true;
            init(members[i].toString(), checked);
            checked[i] = false;
        }
        return result.size();
    }

    public boolean check(String input) {
        for (String s : pattern) {
            int a = input.indexOf(s.charAt(0));
            int b = input.indexOf(s.charAt(2));
            char compare = s.charAt(3);
            int num = s.charAt(4) - '0' + 1;
            if (compare == '=') {
                if (num != Math.abs(a - b)) {
                    return false;
                }
            } else if (compare == '<') {
                if (num <= Math.abs(a - b)) {
                    return false;
                }
            } else {
                if (num >= Math.abs(a - b)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void init(String input, boolean[] checked) {
        if (input.length() == members.length) {
            if(check(input))result.add(input);
            return;
        }
        for (int i = 0; i < members.length; i++) {
            if (checked[i]) {
                continue;
            }
            checked[i] = true;
            init(input + members[i], checked);
            checked[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Picture().solution(1, new String[]{"N~F=0", "R~T>2"}));
    }
}
