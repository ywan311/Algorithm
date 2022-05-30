package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 0 일때 처리 남음
 * 0이 아닌 친구들은 queue의 마지막으로 들어갈 수 없음
 *
 * */
public class P1132 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Character,Long> map = new HashMap<>();
        List<Element> list = new ArrayList<>();
        boolean[] checkZero = new boolean[10];
        for(int i =0;i<N ;i++){
            String s = br.readLine();
            checkZero[s.charAt(0)-'A']=true;
            for(int j = s.length()-1;j>=0;j--){
                char c = s.charAt(j);
                map.put(c,map.getOrDefault(c,0L)+(long)Math.pow(10,s.length()-j-1));
            }
        }

        for(char c : map.keySet()){
            list.add(new Element(c,map.get(c)));
        }
        int count = 0;
        for (boolean b : checkZero) {
            if (b) {
                count++;
            }
        }
        int start = 9;
        long answer = 0;
        System.out.println(Arrays.toString(checkZero));
        list.sort((o1, o2) -> (int) (o2.value-o1.value));
        if(list.size()==10){
            for(int i =list.size()-1;i>=0;i--){
                Element e = list.get(i);
                if(!checkZero[e.c-'A']){
                    list.remove(i);
                    list.add(e);
                    break;
                }
            }
        }
        Queue<Element> queue = new LinkedList<>(list);
        System.out.println(queue);


        while(!queue.isEmpty()){
            Element e = queue.poll();
            answer+=e.value*start;
            start--;
        }
        System.out.println(answer);

    }
    static class Element{
        char c;
        long value;
        public Element(char c, long value) {
            this.c = c;
            this.value = value;
        }
        @Override
        public String toString() {
            return "Element{" +
                    "c=" + c +
                    ", value=" + value +
                    '}';
        }
    }
}
