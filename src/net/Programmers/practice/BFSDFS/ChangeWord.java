package net.Programmers.practice.BFSDFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ChangeWord {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean visited[] = new boolean[words.length];

        ArrayList<String> list = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);

        int n = begin.length();

        while (true) {
            answer++;
            while (!queue.isEmpty()) {
                System.out.println(queue);
                String current = queue.poll();
                for(int i=0;i<words.length;i++){
                    if(visited[i])continue;
                    String word = words[i];
                    int cnt=0;
                    for(int j=0;j<n;j++){
                        if(word.charAt(j)==current.charAt(j))cnt++;
                    }
                    if(cnt==n-1){
                        System.out.println(word);
                        visited[i]=true;
                        list.add(word);
                    }
                }
            }
            if (list.contains(target)) return answer;
            if(list.isEmpty())return 0;
            queue.addAll(list);
            list.clear();
        }
    }

    public static void main(String[] args) {
        System.out.println(new ChangeWord().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log","cog"}));
    }
}
