package net.Programmers.practice.Hash;

import java.util.HashMap;
import java.util.Iterator;

public class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            else map.put(clothes[i][1], 1);
        }
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            answer *= (map.get(key) + 1);
        }
        return answer - 1;
    }

    public static void main(String[] arg) {
        System.out.println(new Camouflage().solution(new String[][]{{"yellow_hat", "face"}, {"blue_sunglasses", "face"}, {"green_turban", "face"}}));
    }
}
