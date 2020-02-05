package net.Programmers.practice;

import java.util.*;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreMap = new HashMap();
        for (int i = 0; i < genres.length; i++) {
            if (genreMap.containsKey(genres[i])) genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);
            else genreMap.put(genres[i], plays[i]);
        }
        Iterator iterator = sortByValue(genreMap).iterator();

        ArrayList<Integer> answerList = new ArrayList<>();

        while(iterator.hasNext()){
            HashMap<Integer, Integer> playMap = new HashMap<>();
            String s = iterator.next().toString();
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(s)) {
                    playMap.put(i, plays[i]);
                }
            }
            System.out.println(playMap);
            Iterator playList = sortByValue(playMap).iterator();
            int cnt = 0;
            while(playList.hasNext()&&cnt<2){
                Integer tmp = (Integer)playList.next();
                System.out.println(tmp);
                answerList.add(tmp);
                cnt++;
            }
        }
        int answer[] = new int[answerList.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = answerList.remove(0);
        }
        return answer;
    }

    public static List sortByValue(final Map map) {
        List<?> list = new ArrayList();
        list.addAll(map.keySet());
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                return ((Comparable) v2).compareTo(v1);            }
        });
//        Collections.reverse(list); // 주석시 오름차순

        return list;


    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BestAlbum().solution(new String[]{ "c", "p", "c", "c", "p"}, new int[]{ 500, 600, 150, 800, 2500})));
    }
}
