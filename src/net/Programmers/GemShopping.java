package net.Programmers;

import java.util.*;

public class GemShopping {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, gems);
        Map<String,Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        int left=0;
        int start = 0;
        int length=gems.length;

        for (String gem : gems) {
            map.put(gem, map.getOrDefault(gem, 0) + 1);
            queue.offer(gem);

            while (true) {
                if (map.get(queue.peek()) > 1) {
                    String tmp = queue.poll();
                    map.put(tmp, map.get(tmp) - 1);
                    left++;
                } else {
                    break;
                }
            }
            if (set.size() == map.size() && length > queue.size()) {
                start = left;
                length = queue.size();
            }

        }
        return new int[]{start+1, length+start};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GemShopping().solution(new String[]{"DIA", "EM","EM", "RUB", "DIA"})));
    }
}
